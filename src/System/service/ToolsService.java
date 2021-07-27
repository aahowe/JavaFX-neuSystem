package System.service;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.time.LocalDateTime;

/**
 * @author wanghao
 */
public class ToolsService {

    /** 存储时间 */
    private static int year;
    private static int month;
    private static int day;
    private static int second;
    private static int minute;
    private static int hour;

    public static void showtime(Label timeInfoLabel){
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            year = LocalDateTime.now().getYear();
            month = LocalDateTime.now().getMonth().getValue();
            day = LocalDateTime.now().getDayOfMonth();
            second = LocalDateTime.now().getSecond();
            minute = LocalDateTime.now().getMinute();
            hour = LocalDateTime.now().getHour();
            timeInfoLabel.setText(String.format("欢迎！现在是 %d年%d月%d日, %02d:%02d:%02d", year, month, day, hour, minute, second));
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
}
