package com.wahid.genarch.genarch.setup

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiManager

class ProjectStructureGenerator(private val event: AnActionEvent) {
    fun generate(architecture: String, packageName: String) {
        val project = event.project ?: return
        val psiManager = PsiManager.getInstance(project)
        val baseDir = project.baseDir

        when (architecture) {
            "MVVM" -> setupMVVMStructure(psiManager, baseDir, packageName)
            "MVC" -> setupMVCStructure(psiManager, baseDir, packageName)
            "Clean Architecture" -> setupCleanArchitectureStructure(psiManager, baseDir, packageName)
        }
    }

    private fun setupMVVMStructure(psiManager: PsiManager, baseDir: VirtualFile, packageName: String) {
        val basePackageDir = createDirectory(baseDir, packageName.replace(".", "/"))
        createDirectory(basePackageDir, "model")
        createDirectory(basePackageDir, "viewmodel")
        createDirectory(basePackageDir, "view")
    }

    private fun setupMVCStructure(psiManager: PsiManager, baseDir: VirtualFile, packageName: String) {
        val basePackageDir = createDirectory(baseDir, packageName.replace(".", "/"))
        createDirectory(basePackageDir, "model")
        createDirectory(basePackageDir, "view")
        createDirectory(basePackageDir, "controller")
    }

    private fun setupCleanArchitectureStructure(psiManager: PsiManager, baseDir: VirtualFile, packageName: String) {
        val basePackageDir = createDirectory(baseDir, packageName.replace(".", "/"))

        val dataDir = createDirectory(basePackageDir, "data")
        createDirectory(dataDir, "repository")
        createDirectory(dataDir, "datasource")

        val domainDir = createDirectory(basePackageDir, "domain")
        createDirectory(domainDir, "model")
        createDirectory(domainDir, "usecase")

        val presentationDir = createDirectory(basePackageDir, "presentation")
        createDirectory(presentationDir, "viewmodel")
        createDirectory(presentationDir, "view")
    }

    private fun createDirectory(parent: VirtualFile, name: String): VirtualFile {
        return parent.createChildDirectory(this, name)
    }
}
