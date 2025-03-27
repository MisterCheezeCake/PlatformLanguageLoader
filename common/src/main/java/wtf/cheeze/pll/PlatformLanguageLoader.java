/*
 * Copyright (C) 2025 MisterCheezeCake
 *
 * This file is part of PlatformLanguageLoader.
 *
 * PlatformLanguageLoader is free software: you can redistribute it
 * and/or modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * PlatformLanguageLoader is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with PlatformLanguageLoader. If not, see <https://www.gnu.org/licenses/>.
 */
package wtf.cheeze.pll;

import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.resources.ResourceLocation;

/**
 * Contains misc utility methods for the mod
 */
public class PlatformLanguageLoader {

    /**
     * Checks whether the given namespace has an "assets/namespace/lang/platform" folder
     * @param manager The resource manager
     * @param namespace The namespace to check
     */
    public static boolean hasPLLFolder(ResourceManager manager, String namespace) {
        return !manager.getResourceStack(ResourceLocation.fromNamespaceAndPath(namespace, PathFormatter.PLL_FOLDER)).isEmpty();
    }

    /**
     * Checks whether the given namespace has a platform folder for the given platformID
     * @param manager The resource manager
     * @param namespace The namespace to check
     * @param platformID The platform ID to check
     */
    public static boolean hasPlatformFolder(ResourceManager manager, String namespace, String platformID) {
        return !manager.getResourceStack(ResourceLocation.fromNamespaceAndPath(namespace, PathFormatter.formatPlatform(platformID))).isEmpty();

    }

    /**
     * Checks whether the given namespace has a language file for the given platformID and language
     * @param manager The resource manager
     * @param namespace The namespace to check
     * @param platformID The platform ID to check
     * @param lang The lang id to check
     */
    public static boolean hasLangFile(ResourceManager manager, String namespace, String platformID, String lang) {
        return !manager.getResourceStack(ResourceLocation.fromNamespaceAndPath(namespace, PathFormatter.formatFile(platformID, lang))).isEmpty();
    }

    /**
     * Checks whether the given namespace has a generic language file (a file in the root "platform" folder) for the given language.
     * @param manager
     * @param namespace
     * @param lang
     * @return
     */
    public static boolean hasGenericLangFile(ResourceManager manager, String namespace, String lang) {
        return !manager.getResourceStack(ResourceLocation.fromNamespaceAndPath(namespace, PathFormatter.formatGenericFile(lang))).isEmpty();


    }
}