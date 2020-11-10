package com.iuoip.processorScheduling;

public class Process {
    public enum STATE {R, E}  //枚举类型定义状态取值

    private String processName;   //进程名
    private int runTime;   //运行时间
    private int priority;  //优先数
    private STATE state;   //状态

    public Process(int processIndex, int runTime, int priority) {
        this.processName = "P" + processIndex;
        this.runTime = runTime;
        this.priority = priority;
        this.state = STATE.R;
    }

    public int getPriority() {
        return priority;
    }

    public int getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    public void setPriority(int priority) {
        this.priority = priority;
        if (this.priority <= 2) {
            this.priority = 2;
        }
    }

    public void setState(STATE state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Process{" +
                "进程名='" + processName + '\'' +
                ", 运行时间=" + runTime +
                ", 优先级=" + priority +
                ", 状态=" + state +
                '}';
    }
}
