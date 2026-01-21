plugins {
    id("plugintemplate-build")
}

extra["localJarRepo"] = true

dependencies {
    implementation(libs.bundles.ntConfig)
}
