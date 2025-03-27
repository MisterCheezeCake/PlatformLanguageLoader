package wtf.cheeze.pll.mixin;


import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.resources.language.ClientLanguage;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import wtf.cheeze.pll.PathFormatter;
import wtf.cheeze.pll.Platform;
import wtf.cheeze.pll.PlatformLanguageLoader;

import java.util.List;
import java.util.Map;

/**
 * The mixin that powers the mod
 */
@Mixin(ClientLanguage.class)
public abstract class ClientLanguageMixin {

    @Shadow
    private static void appendFrom(String langCode, List<Resource> resourceRefs, Map<String, String> translations) { throw new AssertionError(); }

    @Inject(
            method = "loadFrom",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/resources/language/ClientLanguage;appendFrom(Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)V",
                    shift = At.Shift.AFTER
            )
    )
    private static void pll$loadTranslations(
            ResourceManager resourceManager,
            List<String> definitions,
            boolean rightToLeft,
            CallbackInfoReturnable<ClientLanguage> cir,
            @Local Map<String, String> map,
            @Local(ordinal = 0) String lang,
            @Local(ordinal = 2) String namespace
    ) {
        Platform currentPlatform = Platform.CURRENT;
        if (currentPlatform == null) return;
        if (!PlatformLanguageLoader.hasPLLFolder(resourceManager, namespace)) return;
        if (PlatformLanguageLoader.hasPlatformFolder(resourceManager, namespace, currentPlatform.id)) {
            if (PlatformLanguageLoader.hasLangFile(resourceManager, namespace, currentPlatform.id, lang)) {
                List<Resource> resources = resourceManager.getResourceStack(ResourceLocation.fromNamespaceAndPath(namespace, PathFormatter.formatFile(currentPlatform.id, lang)));
                appendFrom(lang, resources, map);
            } else if (PlatformLanguageLoader.hasGenericLangFile(resourceManager, namespace, lang)) {
                List<Resource> resources = resourceManager.getResourceStack(ResourceLocation.fromNamespaceAndPath(namespace, PathFormatter.formatGenericFile(lang)));
                appendFrom(lang, resources, map);
            }
        }
    }
}
