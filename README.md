# Platform Language Loader

Platform Language Loader (PLL for short) is a Minecraft mod that selectively loads language files based on which platform you are on. This is useful because
sometimes, things are named differently on one platform, and you want to alter the text in your mod or a resource pack based on that.

## How It Works

To add PLL compatible files, create a `platform` folder in your `lang` folder. In this folder, create a subfolder for every platform you want
unique translations for, and add language files. The folder name should be the ID from the table below. You can also create files in the root of `platform`
which will be loaded if none of your platform specific folders were matched

## Platform Types

| Platform           | ID           |
|--------------------|--------------|
| Windows            | `win32`      |
| MacOS              | `darwin`     |
| Linux              | `linux`      |
| Android            | `android`    |
| BSD Varieties      | `bsd`        |
| Other Unix Systems | `other_unix` |

