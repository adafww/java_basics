package main;

import java.util.concurrent.RecursiveAction;

public class FinalGenerator extends RecursiveAction {

    int count;
    int tabCount;
    String preStr;

    FinalGenerator(int count, int tabCount, String preStr){
        this.count = count;
        this.tabCount = tabCount;
        this.preStr = preStr;
    }

    @Override
    protected void compute() {
        for (String s : ListFiles.getList()){
            if(check(s, EmtyList.getList())){
                if(tabCount == 0) {

                    EmtyList.add(tab(s, tabCount));
                    System.out.println(tab(s, tabCount));
                    //System.out.println("size: " + EmtyList.getSize() + " count: " + strings(s).length + " strCount: " + strings(s)[count - 1] + " preStr: " + preStr);
                    new FinalGenerator(++count, ++tabCount, s).compute();

                }else if(coincidence(preStr, s) == count && strings(preStr).length == count){

                    count++;
                    tabCount++;
                    EmtyList.add(tab(s, tabCount));
                    System.out.println(tab(s, tabCount));
                    new FinalGenerator(count, tabCount, s).compute();

                }else {

                    EmtyList.add(tab(s, tabCount));
                    System.out.println(tab(s, tabCount));
                    new FinalGenerator(count, tabCount, s).compute();

                }
            }
        }
    }

    private static int coincidence(String from, String to){
        int cnt = 0;
        for (String s : strings(to)){
            for (String a : strings(from)){
                if (s.equals(a)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    private static boolean check(String str, java.util.List<String> list){
        return (list.stream().filter(a -> a.trim().equals(str)).toList().size() == 0);
    }

    private static String[] strings(String str){
        return str.split("\\/+");
    }

    private static String tab(String str, int count){
        return "\t".repeat(Math.max(0, count)) + str;
    }
}
