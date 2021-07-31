package com.liuyi.springbootdemo.utils;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName TreeNodeUtil
 * @description：树转换工具类
 * @author：liuyi
 * @Date：2021/7/31 17:48
 */
public class TreeNodeUtil {

    public static void main(String[] args) {
        List<TreeNode> parentList = new ArrayList<>();
        TreeNode treeNode0 = new TreeNode(1,"主节点一",0);
        TreeNode treeNode01 = new TreeNode(2,"子节点一",1);
        TreeNode treeNode02 = new TreeNode(3,"子节点二",1);
        TreeNode treeNode011 = new TreeNode(3,"子节点一一",2);
        TreeNode treeNode021 = new TreeNode(3,"子节点二一",3);
        parentList.add(treeNode0);
        parentList.add(treeNode01);
        parentList.add(treeNode02);
        parentList.add(treeNode011);
        parentList.add(treeNode021);
        List<TreeNode> treeNodes = listToTree(parentList);
        System.out.println(treeNodes);
    }


    /**
     * @Author liuyi
     * @Description //TODO
     * @Date 2021/7/31 17:53
     * @Param [list]
     * @return java.util.List<com.liuyi.springbootdemo.utils.TreeNode>
     **/
    public static List<TreeNode> listToTree(List<TreeNode> list){
        //1.找出顶级节点及parentId为0的数据
        List<TreeNode> parentList = list.parallelStream()
                .filter(treeNode -> treeNode.getParentId() == 0)
                .map(parent -> {
                    setChildren(parent, list);
                    return parent;
                })
                .collect(Collectors.toList());
        return parentList;
    }
    
    /**
     * @Author liuyi 
     * @Description //设置树的Children
     * @Date 2021/7/31 18:04 
     * @Param [parentId, list] 
     * @return void
     **/
    public static void setChildren(TreeNode parent,List<TreeNode> list){
        //找到当前父节点的所有子节点
        List<TreeNode> childrenList = list.parallelStream()
                .filter(node -> node.getParentId() == parent.getId())
                .collect(Collectors.toList());
        if(childrenList!=null&&childrenList.size()>0){
            //设置子节点
            parent.setChildren(childrenList);
            //继续给子节点赋值
            childrenList.parallelStream()
                    .forEach(node -> {
                        setChildren(node, list);
                    });
        }
    }
}

@Data
class TreeNode{

    public TreeNode() {
    }

    public TreeNode(int id, String label, int parentId) {
        this.id = id;
        this.label = label;
        this.parentId = parentId;
    }
    private int id;
    private String label;
    private int parentId;
    private List<TreeNode> children;
}
