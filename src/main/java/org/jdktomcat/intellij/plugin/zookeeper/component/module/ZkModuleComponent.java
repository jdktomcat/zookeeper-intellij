package org.jdktomcat.intellij.plugin.zookeeper.component.module;

import com.intellij.openapi.module.ModuleComponent;
import org.jetbrains.annotations.NotNull;

public class ZkModuleComponent implements ModuleComponent {

    @Override
    public void initComponent() {

    }

    @Override
    public void disposeComponent() {

    }

    @Override
    public void moduleAdded() {
        System.out.println("module added");
    }

    @NotNull
    @Override
    public String getComponentName() {
        return "zk";
    }
}
