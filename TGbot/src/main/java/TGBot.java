import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TGBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update){
        //Реакция на текст
        if (update.hasMessage() && update.getMessage().hasText()){
            String text = update.getMessage().getText();
            String lowertext = (text.toLowerCase());
            SendMessage message   = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            if(lowertext.equals("case1")){
                message.setText("reply1");
            }
            else if (lowertext.equals("case2")){
                message.setText("reply2");
            }
            else if(lowertext.equals("case3")){
                message.setText("reply3");
            }
            try{
                execute(message);
            }
            catch (TelegramApiException e){
                e.printStackTrace();
            }
        }
        // Реакция на аудио и видео
        if (update.hasMessage() && update.getMessage().hasPhoto() || update.hasMessage() && update.getMessage().hasAudio()){
            SendAnimation animation   = new SendAnimation();
            animation.setChatId(update.getMessage().getChatId().toString());
            try{
                execute(animation);
            }
            catch (TelegramApiException e){
                e.printStackTrace();
            }

        }
    }
    @Override
    public String getBotUsername(){
        return "bot_username";
    }

    @Override
    public String getBotToken(){
        return "bot_token";
    }
}