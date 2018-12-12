package org.jdktomcat.intellij.plugin.zookeeper.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.ui.treeStructure.Tree;
import org.jdktomcat.intellij.plugin.zookeeper.component.project.ZkProjectComponent;
import org.jdktomcat.intellij.plugin.zookeeper.ui.ZkNode;
import org.jdktomcat.intellij.plugin.zookeeper.vfs.ZkNodeVirtualFile;

import javax.swing.tree.TreePath;

/**
 * open zk node in editor action
 *
 * @author jdktomcat
 */
public class OpenZkNodeInEditorAction extends AnAction {

    public void actionPerformed(AnActionEvent actionEvent) {
        ZkProjectComponent zkProjectComponent = ZkProjectComponent.getInstance(actionEvent.getProject());
        Tree zkTree = zkProjectComponent.getZkTree();
        TreePath treePath = zkTree.getSelectionPath();
        ZkNode zkNode = (ZkNode) treePath.getLastPathComponent();
        FileEditorManager fileEditorManager = FileEditorManager.getInstance(actionEvent.getProject());
        ZkNodeVirtualFile virtualFile = (ZkNodeVirtualFile) zkProjectComponent.getFileSystem().findFileByPath(zkNode.getFilePath());
        if (virtualFile != null) {
            virtualFile.setLeaf();
            fileEditorManager.openFile(virtualFile, true);
        }
    }
}
