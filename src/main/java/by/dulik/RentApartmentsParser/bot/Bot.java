package by.dulik.RentApartmentsParser.bot;

import by.dulik.RentApartmentsParser.entity.TelegramChat;
import by.dulik.RentApartmentsParser.repository.TelegramChatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;

@Component
public class Bot extends TelegramLongPollingBot {

    private static final Logger log = LoggerFactory.getLogger(Bot.class);
    private TelegramChatRepository telegramChatRepository;
    private List<TelegramChat> telegramChats;

    @Autowired
    public Bot(TelegramChatRepository telegramChatRepository) {
        this.telegramChatRepository = telegramChatRepository;
        telegramChats = telegramChatRepository.findAll();
    }

    private void saveNewChatId(String chatId) {
        AtomicBoolean isFind = new AtomicBoolean(false);
        telegramChats.forEach(telegramChat -> {
            if (!telegramChat.getChatId().equals(chatId)) {
                isFind.set(true);
            }
        });
        if (telegramChats.size() == 0 || isFind.get()) {
            telegramChatRepository.save(new TelegramChat(chatId));
            telegramChats = telegramChatRepository.findAll();
        }
    }

    private void stopChatId(String chatId) {
        telegramChats.forEach(telegramChat -> {
            if (telegramChat.getChatId().equals(chatId)) {
                telegramChatRepository.deleteByChatId(chatId);
                telegramChats = telegramChatRepository.findAll();
            }
        });
    }

    /**
     * Метод для приема сообщений.
     *
     * @param update Содержит сообщение от пользователя.
     */
    @Override
    public void onUpdateReceived(Update update) {
        String text = update.getMessage().getText();
        String chatId = update.getMessage().getChatId().toString();
        switch (text) {
            case "/start":
                saveNewChatId(chatId);
                sendMsg(chatId, "Привет! Ура, теперь ты будешь получать новые предложения по квартирам с " +
                        "сайта Onliner, Neagent, Kufar. Количество комнат 1-2. Ценовой дипазон до 250$ и только от собственников. " +
                        "Если хочешь остановить рассылку введи команду /stop");
                break;
            case "/stop":
                stopChatId(chatId);
                sendMsg(chatId, "Рассылка остановлена. Надеюсь вам понравились мои предложения)");
                break;
            case "/show_chats":
                sendMsg(chatId, telegramChats.toString());
                break;
            default:
//                sendMsg(chatId, "Эхо: " + text.replace("_", "\\_"));
                sendMsg(chatId, "Эхо: " + text);
                break;
        }
    }

    public void sendTextAllMuteUsers(String text) {
        telegramChats.forEach(telegramChat -> sendMsg(telegramChat.getChatId(), text));
    }

    public void sendImgFromUrlAllMuteUsers(String url, String caption) {
        telegramChats.forEach(telegramChat -> sendImageFromUrl(telegramChat.getChatId(), url, caption));
    }

    /**
     * Метод для настройки сообщения и его отправки.
     *
     * @param chatId id чата
     * @param s      Строка, которую необходимот отправить в качестве сообщения.
     */
    private synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(false);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            log.info(Level.SEVERE.toString(), "Exception: ", e.toString());
        }
    }

    private synchronized void sendImageFromUrl(String chatId, String url, String caption) {
        SendPhoto sendPhotoRequest = new SendPhoto();
        sendPhotoRequest.setChatId(chatId);
        sendPhotoRequest.setPhoto(url);
        sendPhotoRequest.setCaption(caption);
        try {
            execute(sendPhotoRequest);
        } catch (TelegramApiException e) {
            log.info(Level.SEVERE.toString(), "Exception: ", e.toString());
        }
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        for (Update update :
                updates) {
            onUpdateReceived(update);
        }
    }

    /**
     * Метод возвращает имя бота, указанное при регистрации.
     *
     * @return имя бота
     */
//    @Override
//    public String getBotUsername() {
//        return "DulikCheckerRent";
//    }
//
//    /**
//     * Метод возвращает token бота для связи с сервером Telegram
//     *
//     * @return token для бота
//     */
//    @Override
//    public String getBotToken() {
//        return "656674659:AAFr7WrmShtjVKSX1gnT0dvp9i4NGXnVlmI";
//    }
    @Override
    public String getBotUsername() {
        return "DChRTestBot";
    }

    @Override
    public String getBotToken() {
        return "742716883:AAEzbZM8vL2G5kXFXfBwKPVc8L7c7JI2Yv0";
    }

}
