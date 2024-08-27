package com.d

import com.d.entension.ConfigExtension
import com.d.tasks.AddJunkFileGuardTask
import com.d.tasks.RenameClassGuardTask
import com.d.tasks.RenameResGuardTask
import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 *   █████▒█    ██  ▄████▄   ██ ▄█▀       ██████╗ ██╗   ██╗ ██████╗
 * ▓██   ▒ ██  ▓██▒▒██▀ ▀█   ██▄█▒        ██╔══██╗██║   ██║██╔════╝
 * ▒████ ░▓██  ▒██░▒▓█    ▄ ▓███▄░        ██████╔╝██║   ██║██║  ███╗
 * ░▓█▒  ░▓▓█  ░██░▒▓▓▄ ▄██▒▓██ █▄        ██╔══██╗██║   ██║██║   ██║
 * ░▒█░   ▒▒█████▓ ▒ ▓███▀ ░▒██▒ █▄       ██████╔╝╚██████╔╝╚██████╔╝
 *  ▒ ░   ░▒▓▒ ▒ ▒ ░ ░▒ ▒  ░▒ ▒▒ ▓▒       ╚═════╝  ╚═════╝  ╚═════╝
 *  ░     ░░▒░ ░ ░   ░  ▒   ░ ░▒ ▒░
 *  ░ ░    ░░░ ░ ░ ░        ░ ░░ ░
 *           ░     ░ ░      ░  ░
 * @author : Leo
 * @date : 2022/12/16 18:56
 * @desc :
 * @since : xinxiniscool@gmail.com
 */
class ClassResGuardPlugin : Plugin<Project> {
    override fun apply(project: Project) {
//        checkApplicationPlugin(project)
        val configExtension = project.extensions.create("classResGuardYang", ConfigExtension::class.java)
        project.tasks.create("renameRes", RenameResGuardTask::class.java, configExtension)
        project.tasks.create("addJunkFile", AddJunkFileGuardTask::class.java, configExtension)
        project.tasks.create("renameClass", RenameClassGuardTask::class.java, configExtension)
//        project.tasks.create("renameDir", RenameDirGuardTask::class.java, configExtension)
    }


    private fun checkApplicationPlugin(project: Project) {
        if (!project.plugins.hasPlugin("com.android.application")) {
            throw  GradleException("Android Application plugin required")
        }
    }
}