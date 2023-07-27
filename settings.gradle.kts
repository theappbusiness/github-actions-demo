pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "GithubActionsDemo"
include(":app")

/*
    Setup to allow build scans to be published
    If builds scans are not needed this is not required.
 */
plugins {
    id("com.gradle.enterprise") version "3.14.1"
}

gradleEnterprise {
    // configuration
    buildScan {
        if (System.getenv("CI_BUILD").orEmpty().equals("true", ignoreCase = true)) {
            // Connecting to scans.gradle.com by agreeing to the terms of service
            termsOfServiceUrl = "https://gradle.com/terms-of-service"
            termsOfServiceAgree = "yes"
        }
    }
}
