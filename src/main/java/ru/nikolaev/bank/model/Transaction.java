    package ru.nikolaev.bank.model;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;
    import org.springframework.data.annotation.CreatedDate;
    import org.springframework.data.jpa.domain.support.AuditingEntityListener;

    import java.math.BigDecimal;
    import java.time.Instant;

    @Getter
    @Setter
    @Entity
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name = "transactions")
    @EntityListeners(AuditingEntityListener.class)
    public class Transaction {
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @ManyToOne
        @JoinColumn(name = "sender_account", referencedColumnName = "id", nullable = false)
        private Account senderAccount;

        @ManyToOne
        @JoinColumn(name = "receiver_account", referencedColumnName = "id", nullable = false)
        private Account receiverAccount;

        @Column(name = "amount", nullable = false)
        private BigDecimal amount;

        @Column(name = "currency", nullable = false)
        @Enumerated(EnumType.STRING)
        private Currency currency;

        @CreatedDate
        @Column(name = "created_at", nullable = false)
        private Instant createdAt;
    }
