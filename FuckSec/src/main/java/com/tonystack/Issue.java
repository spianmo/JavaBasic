package com.tonystack;

/*
 * Copyright (c) 2020
 * @Project:TrackerProject
 * @Author:Finger
 * @FileName:Issue.java
 * @LastModified:2020-10-26T17:24:59.388+08:00
 */


/**
 * @author Finger
 */
public class Issue {
    public int id;
    public String type;
    public String title;
    public IssueItem[] items;
    public String answer;

    public Issue(){
        items = new IssueItem[4];
    }

    static class IssueItem {
        public String iid;
        public String detail;

        public IssueItem(String iid, String detail) {
            this.iid = iid;
            this.detail = detail;
        }

        @Override
        public String toString() {
            return iid + ":" + detail;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("题号:").append(id).append(" ");
        sb.append("题型:").append(type).append(" ");
        sb.append("题目:").append(title).append(" ").append("答案:").append(answer).append("\n");
        sb.append("选项:");
        for (IssueItem item : items) {
            if (!type.equals("是非题")) {
                sb.append(item.iid).append("、").append(item.detail).append(" ");
            } else {
                if (!"C".equals(item.iid) && !"D".equals(item.iid)) {
                    sb.append(item.iid).append("、").append(item.detail).append(" ");
                }
            }

        }
        return sb.toString();
    }


}
