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

import org.apache.commons.lang3.SystemProperties;
import org.apache.commons.lang3.SystemUtils;

import java.util.function.Supplier;

/**
 * Represents pretty much any platform capable of running Java, or at least every platform
 * that {@link SystemUtils} supports.
 */
public enum Platform {
    /**
     * Good plain old Windows.
     */
    WINDOWS("win32", () -> SystemUtils.IS_OS_WINDOWS),
    /**
     * Good plain old macOS.
     */
    MAC("darwin", () -> SystemUtils.IS_OS_MAC),
    /**
     * Good plain old Linux, or as I've recently taken to...
     */
    LINUX("linux", () -> SystemUtils.IS_OS_LINUX),
    /**
     * Android, for people who think pojav is a please experience.
     * We can't use SystemUtils here because the android check was not added until 3.15, and 1.21 ships 3.14, this is the same exact check that SystemUtils uses though.
     */
    ANDROID("android", () -> SystemProperties.getJavaVendor().contains("Android")),
    /**
     * BSD, for the three people who use one of its varieties as their desktop OS.
     */
    BSD("bsd", () -> SystemUtils.IS_OS_FREE_BSD || SystemUtils.IS_OS_OPEN_BSD || SystemUtils.IS_OS_NET_BSD),
    /**
     * Another unix platform, if anyone reading this runs minecraft on one of these, please contact me, because I'm seriously concerned about you.
     */
    OTHER_UNIX("other_unix", () -> SystemUtils.IS_OS_SUN_OS || SystemUtils.IS_OS_SOLARIS ||  SystemUtils.IS_OS_AIX || SystemUtils.IS_OS_HP_UX || SystemUtils.IS_OS_IRIX);

    public static final Platform CURRENT = currentPlatform();

    public final String id;
    private final Supplier<Boolean> test;

    Platform(String id, Supplier<Boolean> test) {
        this.id = id;
        this.test = test;
    }

    public static Platform currentPlatform() {
        for (Platform platform : values()) {
            if (platform.test.get()) {
                return platform;
            }
        }
        return null;
    }

    public boolean isUnixLike() {
        return this == LINUX || this == MAC || this == BSD || this == ANDROID || this == OTHER_UNIX;
    }
}