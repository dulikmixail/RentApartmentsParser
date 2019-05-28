package by.dulik.RentApartmentsParser.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class TelegramChat {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String chatId;

    protected TelegramChat() {
    }

    public TelegramChat(String chatId) {
        this.chatId = chatId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelegramChat that = (TelegramChat) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(chatId, that.chatId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chatId);
    }

    @Override
    public String toString() {
        return "TelegramChat{" +
                "id=" + id +
                ", chatId='" + chatId + '\'' +
                '}';
    }
}
