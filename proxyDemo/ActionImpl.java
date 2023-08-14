package proxyDemo;

public class ActionImpl implements Action{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ActionImpl(String name) {
        this.name = name;
    }

    @Override
    public String action(int index) {
        for (int i= 0 ; i < index ; i++) {
            System.out.println("正在行动");
        }
        return "行动结束";
    }

    @Override
    public String rest(int index) {
        for (int i = 0 ; i < index ; i++) {
            System.out.println("正在休息");
        }
        return "休息结束";
    }
}
