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

/**
 * Utilities for formatting resource paths, this is namespace agnostic since it will read from every namespace
 */
public class PathFormatter {
    public static final String PLL_FOLDER = "lang/platform";

    /**
     * Formats a path to a platform folder
     */
    public static String formatPlatform(String platform) {
        return String.format(PLATFORM_FOLDER, platform);
    }

    /**
     * Formats a path to a platform language file
     */
    public static String formatFile(String platform, String lang) {
        return String.format(PLATFORM_FILE, platform, lang);
    }

    /**
     * Formats a path to a generic language file
     */
    public static String formatGenericFile(String lang) {
        return String.format(GENERIC_FILE, lang);
    }

    private static final String PLATFORM_FOLDER = PLL_FOLDER + "/%s";
    private static final String GENERIC_FILE = PLL_FOLDER + "/%s.json";
    private static final String PLATFORM_FILE = PLATFORM_FOLDER + "/%s.json";
}
