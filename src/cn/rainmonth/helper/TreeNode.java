package cn.rainmonth.helper;

import java.util.ArrayList;
import java.util.List;

/**
 * 普通的数
 *
 * @author 张豪成
 * @date 2019/9/21
 */
public class TreeNode {

    List<TreeNode> childs;

    public TreeNode() {
        this.childs = new ArrayList<>();
    }

    public void addNode(TreeNode node) {
        childs.add(node);
    }
}
