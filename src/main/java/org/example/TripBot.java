package org.example;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Location;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import javax.swing.*;
import java.io.File;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;


public class TripBot extends TelegramLongPollingBot {

    public int level = 0;
    public TripBot() {

    }

    @Override
    public String getBotUsername() {
        return "TripNoyBot";
    }

    @Override
    public String getBotToken() {
        return "7211356986:AAFZTNxQYxvw21AY6eFwdDoQRzqiAkpmhFE";
    }

    @Override
    public void onUpdateReceived(Update update) {
        String textMessage = "";
        long chatId;
        String callbackData = "";
        chatId = this.getChatId(update);

        if (update.hasMessage() && update.getMessage().hasText()) {
            textMessage = update.getMessage().getText();
        } else if (update.hasCallbackQuery()) {
            callbackData = update.getCallbackQuery().getData();
        }

        switch (level) {
            case 0 -> start(chatId);
            case 1 -> level1(chatId, textMessage);
            case 2 -> level2(chatId, textMessage);
            case 3 -> level3(chatId, textMessage);
            case 4 -> level4(chatId, textMessage);
            case 5 -> level5(chatId, textMessage);
            case 6 -> level6(chatId, textMessage);
            case 7 -> level7(chatId, textMessage);
            case 8 -> level8(chatId, textMessage);
            case 9 -> level9(chatId, textMessage);
            case 10 -> level10(chatId, textMessage);
            case 11 -> level11(chatId, textMessage);
            case 12 -> level12(chatId, textMessage);
            case 13 -> level13(chatId, textMessage);
            case 14 -> level14(chatId, textMessage);
        }
    }


    void start (long chatId){
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("ברוכים הבאים למירוץ הגדול!\n"
                + "חיכינו לכם הרבה זמן.\n"
                + "במהלך היום תעברו מתחנה לתחנה על ידי פתרון החידות והרמזים שלנו\n"
                + "מקווים שקמתם על הצד החד שלכם\n"
                + "לצורך זיהוי וקבלת הרמז הראשון להתחלת המירוץ אנא רשמו את תעודת הזהות שלך הלקוח שביצע את ההזמנה\n"
                + "בהצלחה!");
        InlineKeyboardButton starter = new InlineKeyboardButton("Start");
        List<InlineKeyboardButton>topRow= Arrays.asList(starter);
        List<List<InlineKeyboardButton>> keyboard = List.of(topRow);
        InlineKeyboardMarkup inlineKeyboardMarkup=new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(keyboard);
        send(message);
        this.level = 1;
    }

    void level1 (long chatId, String textMessage){
        String photoPath = "src/main/java/org/example/images/big.jpg";
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(String.valueOf(chatId));
        sendPhoto.setPhoto(new InputFile(new File(photoPath)));
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        if(textMessage.equals("307904276")){
            message.setText("שלום בן, נוי, אביהו ועדן! בהצלחה במסע. מה היעד הראשון בטיול?");
            try {
                execute(sendPhoto);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            photoPath = "src/main/java/org/example/images/kid.jpg";
            sendPhoto.setPhoto(new InputFile(new File(photoPath)));
            try {
                execute(sendPhoto);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            this.level = 2;
        }
        else {
            message.setText("לא קיים משתמש כזה, אנא נסו שנית");
        }
        send(message);
    }

    void level2(long chatId, String textMessage) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        if (textMessage.equals("ביגה")) {
            message.setText("מממממ, תשובה נכונה! בתיאבון כשתסיימו ותרצו להמשיך - לחצו על הכפתור");
            message.setReplyMarkup(createInlineKeyboard("להמשיך", "next_level"));
        } else {
            message.setText("לא טוב, נסו שוב");
        }
        send(message);
    }



    void level3 (long chatId, String textMessage){
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("מקווה שאכלתם טוב כי יש לכם עוד מלא עבודה\n"
                + "מה אומרים במוצאי חג?\n"
                + "3 + _ _ _ _ _ - _ _ _ _ _ _\n");
        this.level = 4;
        send(message);
    }

    void level4 (long chatId, String textMessage){
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        if (textMessage.equals("מועדים לשמחה 3")) {
            message.setText("ידעתי שיש לי פה עסק עם חנונים של חידות רק לא ידעתי עד כמה\n"
                    + "סעו לעדן ואביהו הם מחכים לכם הרבה זמן\n"
                    + "כרגיל, כשתרצו להמשיך תלחצו על הכפתור\n");
            message.setReplyMarkup(createInlineKeyboard("להמשיך", "next_level"));
        } else {
            message.setText("לא טוב, נסו שוב");
        }
        send(message);
    }

    void level5 (long chatId, String textMessage){
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("ברוכים המצטרפים אביהו ועדן אני מקווה שאתם קצת יותר טובים מבן ונוי בחידות כי אנחנו עולים רמה\n"
                + "מהו המקום שבו הזמן הוא האויב ופתרון הוא המפתח?\n");
        this.level = 6;
        send(message);
    }

    void level6 (long chatId, String textMessage){
        String photoPath = "src/main/java/org/example/images/shtoolim.jpeg";
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(String.valueOf(chatId));
        sendPhoto.setPhoto(new InputFile(new File(photoPath)));
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        if (textMessage.equals("חדר בריחה")) {
            message.setText("לא רע...\n"
                    + "מה השם של חדר הבריחה?\n");
            try {
                execute(sendPhoto);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            this.level = 7;
        } else {
            message.setText("לא טוב, נסו שוב");
        }
        send(message);
    }


    void level7 (long chatId, String textMessage){
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        if (textMessage.equals("שתולים")) {
            message.setText("איך אמר פעם מישהו חכם? בחורים טובים לא טועים\n"
                    + "חדר בריחה שתולים בראשון לציון, דוד סחרוב 17\n"
                    + "כשתסיימו שם ותרצו להמשיך, תלחצו על הכפתור כמובן\n");
            message.setReplyMarkup(createInlineKeyboard("להמשיך", "next_level"));
        } else {
            message.setText("לא טוב, נסו שוב");
        }
        send(message);
    }

    void level8 (long chatId, String textMessage){
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("מעניין אם אחרי חדר בריחה נמאס לכם מחידות כבר\n"
                + "זה לא באמת משנה לי כבר שילמתם\n"
                + "הנה מה שתצטרכו כדי שאתן לכם את המקום הבא:\n"
                + "חברו את תעודת הזהות של ארבעתכם\n"
                + "תחלקו בחודש שערן מדר נולד בו\n"
                + "תכפילו בחודש שבו נולד שילה אבני\n"
                + "מה קיבלתם?\n");
        this.level = 9;
        send(message);
    }

    void level9 (long chatId, String textMessage){
        SendLocation sendLocation = new SendLocation();
        sendLocation.setChatId(String.valueOf(chatId));
        sendLocation.setLatitude(31.982753480087265);
        sendLocation.setLongitude(34.76854725038599);
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        if (textMessage.equals("2834667020")) {
            message.setText("כל הכבוד!\n"
                    + "נסיעה נעימה\n"
                    + "כשתסיימו שם ותרצו להמשיך, תודיעו לי\n");
            try {
                execute(sendLocation);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            message.setReplyMarkup(createInlineKeyboard("להמשיך", "next_level"));
        } else {
            message.setText("לא טוב, נסו שוב");
        }
        send(message);
    }

    void level10 (long chatId, String textMessage){
        SendLocation sendLocation = new SendLocation();
        sendLocation.setChatId(String.valueOf(chatId));
        sendLocation.setLatitude(32.07810016425866);
        sendLocation.setLongitude(34.76864581110088);
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("מקווה שנהנתם ולא דרסתם את נוי\n"
                + "תחנו במיקום המצורף ותקראו לי כרגיל לחידות נוספות\n");
        try {
            execute(sendLocation);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        message.setReplyMarkup(createInlineKeyboard("להמשיך", "next_level"));
        send(message);
    }

    void level11 (long chatId, String textMessage){
        String photoPath = "src/main/java/org/example/images/Kothai.png";
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(String.valueOf(chatId));
        sendPhoto.setPhoto(new InputFile(new File(photoPath)));
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        this.level = 12;
    }


    void level12 (long chatId, String textMessage) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        if (textMessage.equals("קותאי") || textMessage.equals("קוטאי")) {
            message.setText("בום\n"
                    + "יפה מאוד אה, תהנו\n"
                    + "בסיום, תנו לחיצה על הכפתור\n");
            message.setReplyMarkup(createInlineKeyboard("להמשיך", "next_level"));
        } else {
            message.setText("לא טוב, נסו שוב");
        }
        send(message);
    }

    void level13 (long chatId, String textMessage) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("יופי, עכשיו כשאתם קצת יותר משוחררים אפשר להמשיך\n"
                + "לפניכם 4 שאלות, תרשמו את התשובות לכל השאלות עם רווחים\n"
                + "1) כמה אליפויות יש למכבי תל אביב?\n"
                + "2) מה השם של המשחק שבן הכי אוהב לשחק בסוני?\n"
                + "3) מה המספר רכב של נוי?\n"
                + "4) אחרי כמה אנשים עדן עוקבת באינסטגרם?\n");
        this.level = 14;
        send(message);
    }

    void level14 (long chatId, String textMessage){
        SendLocation sendLocation = new SendLocation();
        sendLocation.setChatId(String.valueOf(chatId));
        sendLocation.setLatitude(32.07810016425866);
        sendLocation.setLongitude(34.76864581110088);
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        if (textMessage.equals("25 דיאבלו 156156 548")) {
            message.setText("מוריד בפניכם את הכובע\n"
                    + "זה לא היה קל אבל סיימתם\n"
                    + "סעו לדירה, בן יהודה 50 ושמרו על קשר...\n");
            try {
                execute(sendLocation);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else {
            message.setText("לא טוב, נסו שוב");
        }
        send(message);
    }


    private long getChatId (Update update) {
        long chatId = 0;
        if (update.getMessage() != null){
            chatId = update.getMessage().getChatId();
        } else {
            chatId =update.getCallbackQuery().getMessage().getChatId();
        }
        return chatId;
    }

    private void send (SendMessage message){
        try {
            execute(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private InlineKeyboardMarkup createInlineKeyboard(String buttonText, String callbackData) {
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(buttonText);
        button.setCallbackData(callbackData);

        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        keyboardButtonsRow.add(button);

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(keyboardButtonsRow);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(keyboard);
        this.level += 1;
        return inlineKeyboardMarkup;
    }



}