import xyz.jpenilla.resourcefactory.bukkit.BukkitPluginYaml

plugins {
    `plugintemplate-build`
    alias(libs.plugins.paperweight) apply false
    alias(libs.plugins.runPaper)
    alias(libs.plugins.resourceFactoryBukkit) // For plugin.yml generation
    alias(libs.plugins.resourceFactoryPaper) // For paper-plugin.yml generation
}

extra["localJarRepo"] = true

dependencies {
    implementation(projects.modules)
}

tasks {
    runServer {
        minecraftVersion("1.21.11")
        downloadPlugins {
            github("milkbowl", "Vault", "1.7.3", "Vault.jar")
            url("https://download.luckperms.net/1612/bukkit/loader/LuckPerms-Bukkit-5.5.24.jar")
        }
        args("--port", "25566")
        jvmArgs("-Dcom.mojang.eula.agree=true")
    }
}

tasks.jar {
    manifest.attributes(
        "paperweight-mappings-namespace" to "mojang"
    )
}

tasks.withType(xyz.jpenilla.runtask.task.AbstractRun::class) {
    javaLauncher = javaToolchains.launcherFor {
        vendor = JvmVendorSpec.JETBRAINS
        languageVersion = JavaLanguageVersion.of(21)
    }
    jvmArgs("-XX:+AllowEnhancedClassRedefinition")
}

paperPluginYaml {
    name = rootProject.name
    main = "re.neotamia.plugintemplate.core.PluginTemplatePlugin"
    load = BukkitPluginYaml.PluginLoadOrder.STARTUP
    apiVersion = "1.21"
    version = project.version.toString()
}

bukkitPluginYaml {
    name = rootProject.name
    main = "re.neotamia.plugintemplate.core.PluginTemplatePlugin"
    load = BukkitPluginYaml.PluginLoadOrder.STARTUP
    apiVersion = "1.21"
    version = project.version.toString()
}
