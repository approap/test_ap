package com.ap.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        PublicTitle publicTitle = new PublicTitle();
        List<Sub> subList = new ArrayList<Sub>();
        subList.add(new SubA());
        subList.add(new SubB());
        publicTitle.setSubList(subList);

        publicTitle.notify("足球之夜");
    }
}


class PublicTitle {
    public List<Sub> subList;

    public void setSubList(List<Sub> subList) {
        this.subList = subList;
    }

    public void notify(String content) {
        for (Sub sub : subList) {
            sub.getMsg(content);
        }
        System.out.println("notify end");

    }
}

interface Sub {

    public void getMsg(String content);
}


class SubA implements Sub {
    String name = "SubA";
    public void getMsg(String content) {
        System.out.println(name + " get " + content);
    }
}
class SubB implements Sub {
    String name = "SubB";
    public void getMsg(String content) {
        System.out.println(name + " get " + content);
    }
}