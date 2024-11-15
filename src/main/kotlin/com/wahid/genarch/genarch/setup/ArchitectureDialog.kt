package com.wahid.genarch.genarch.setup

import com.intellij.openapi.ui.DialogWrapper
import javax.swing.*
import java.awt.BorderLayout

class ArchitectureDialog : DialogWrapper(true) {
    private val packageNameField = JTextField()
    private val architectureDropdown = JComboBox(arrayOf("MVVM", "MVC", "Clean Architecture"))

    init {
        init()
        title = "Generate Project Structure"
    }

    override fun createCenterPanel(): JComponent {
        val panel = JPanel(BorderLayout())
        val formPanel = JPanel()

        formPanel.add(JLabel("Package Name:"))
        formPanel.add(packageNameField)
        formPanel.add(JLabel("Architecture:"))
        formPanel.add(architectureDropdown)

        panel.add(formPanel, BorderLayout.CENTER)
        return panel
    }

    fun getPackageName(): String = packageNameField.text
    fun getSelectedArchitecture(): String = architectureDropdown.selectedItem.toString()
}

