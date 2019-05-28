package by.dulik.RentApartmentsParser.repository;

import by.dulik.RentApartmentsParser.entity.TelegramChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface TelegramChatRepository extends JpaRepository<TelegramChat, Long> {
    @Transactional
    Long deleteByChatId(String chatId);
}
