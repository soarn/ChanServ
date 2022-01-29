/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    java
    `maven-publish`
    application
}

repositories {
    maven {
        url = uri("https://m2.dv8tion.net/releases")
        content {
            includeGroup("net.dv8tion")
        }
    }

    maven {
        url = uri("https://jenkins.chew.pw/plugin/repository/everything/")
        content {
            includeGroup("pw.chew")
        }
    }

    maven {
        url = uri("https://m2.chew.pro/releases/")
        content {
            includeGroup("pw.chew")
        }
    }

    mavenCentral() {
        content {
            excludeGroup("pw.chew")
            excludeGroup("net.dv8tion")
        }
    }
}

dependencies {
    implementation("net.dv8tion", "JDA", "4.4.0_352")
    implementation("pw.chew", "jda-chewtils", "1.24.1")
    implementation("ch.qos.logback", "logback-classic", "1.2.10")
    implementation("com.squareup.okhttp3", "okhttp", "4.9.3")
    implementation("org.json", "json", "20211205")
    implementation("org.reflections", "reflections", "0.10.2")
    implementation("org.mapdb", "mapdb", "3.0.8")
    implementation("org.knowm.xchart", "xchart", "3.8.1")
    implementation("pw.chew", "Chewbotcca-JDA", "2.0-SNAPSHOT") {
        exclude("io.sentry", "sentry")
        exclude("org.kohsuke", "github-api")
        exclude("org.javalite", "activejdbc")
        exclude("mysql", "mysql-connector-java")
        exclude("org.jsoup", "jsoup")
        exclude("pro.chew.api", "ChewAPI")
        exclude("me.memerator.api", "MemeratorAPI")
        exclude("net.dv8tion", "JDA")
    }
}

group = "pw.chew"
version = "2.0"
description = "ChanServ"
java.sourceCompatibility = JavaVersion.VERSION_17

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

application {
    mainClass.set("pw.chew.chanserv.ChanServ")
}
