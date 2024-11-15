package com.wahid.genarch.genarch

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.wahid.genarch.genarch.setup.ArchitectureDialog
import com.wahid.genarch.genarch.setup.ProjectStructureGenerator

class GenerateArchitectureAction : AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        // Show dialog to get user input
        val dialog = ArchitectureDialog()
        if (dialog.showAndGet()) {
            val architecture = dialog.getSelectedArchitecture()
            val packageName = dialog.getPackageName()

            // Generate files based on selected architecture and input
            ProjectStructureGenerator(event).generate(architecture, packageName)
        }
    }
}
