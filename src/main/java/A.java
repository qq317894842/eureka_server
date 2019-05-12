import org.springframework.web.servlet.DispatcherServlet;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class A {
    private int aa;

    public int getAa() {
        return aa;
    }

    public void setAa(int aa) {
        this.aa = aa;
    }

    public static void main(String[] args) {
        HashMap b;
        //Dispatches to registered handlers for processing a web request
        DispatcherServlet a;
        ScheduledThreadPoolExecutor service4 = (ScheduledThreadPoolExecutor) Executors
                .newScheduledThreadPool(2);
// 如果前面的任务没有完成，则调度也不会启动
        service4.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
// 如果任务执行时间大于间隔时间，那么就以执行时间为准（防止任务出现堆叠）。
                    Thread.sleep(10000);
                    System.out.println(System.currentTimeMillis() / 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }// initialDelay（初始延迟） 表示第一次延时时间 ; period 表示间隔时间
        }, 0, 2, TimeUnit.SECONDS);
        service4.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println(System.currentTimeMillis() / 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }// initialDelay（初始延迟） 表示延时时间；delay + 任务执行时间 = 等于间隔时间 period
        }, 0, 2, TimeUnit.SECONDS);
// 在给定时间，对任务进行一次调度
        service4.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("5 秒之后执行 schedule");
            }
        }, 5, TimeUnit.SECONDS);
    }
}
