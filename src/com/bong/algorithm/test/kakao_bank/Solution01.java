package com.bong.algorithm.test.kakao_bank;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Solution01 {

    private static final String BLANK = " ";
    private static final String SLASH = "/";
    private static final LocalDate LAST_DAY_OF_YEAR = LocalDate.of(2022, 12, 31);

    public int solution(String[] ledgers) {
        Bank bank = new Bank();

        List<Record> records = Arrays.stream(ledgers).map(ledger -> ledger.split(BLANK))
                .map(this::parseToRecord)
                .collect(Collectors.toList());

        records.forEach(bank::depositAndWithdrawal);

        bank.lastWithdrawal();

        int answer = bank.getInterest();
        return answer;
    }

    private Record parseToRecord(String[] array) {
        LocalDate date = getLocalDate(array);
        int interestRate = Integer.parseInt(array[1]);
        int money = Integer.parseInt(array[2]);
        RecordType type = RecordType.from(money);
        return new Record(date, money, interestRate, type);
    }

    private LocalDate getLocalDate(String[] array) {
        String[] monthAndDate = array[0].split(SLASH);
        // 윤년이 아닌 올해로 계산
        LocalDate date = LocalDate.of(2022, Integer.parseInt(monthAndDate[0]), Integer.parseInt(monthAndDate[1]));
        return date;
    }

    public static class Bank {

        private Stack<Record> records = new Stack<>();
        private int interest;

        public int getInterest() {
            return interest;
        }

        public void depositAndWithdrawal(Record record) {
            if (record.isDeposit()) {
                deposit(record);
            } else {
                withdraw(record);
            }
        }


        private void deposit(Record record) {
            records.push(record);
        }

        private void withdraw(Record withdrawalRecord) {
            while (!records.isEmpty()) {
                Record peek = records.peek();
                int interest = peek.calculate(withdrawalRecord);
                this.interest += interest;

                if (peek.getMoney() == 0) {
                    records.pop();
                }
                if (withdrawalRecord.getMoney() == 0) {
                    break;
                }
            }


        }

        public void lastWithdrawal() {
            while (!records.isEmpty()) {
                this.interest += records.pop().calculateAll();
            }
        }
    }

    public static class Record {

        private LocalDate date;
        private int money;
        private double interestRate;
        private RecordType type;

        public Record(LocalDate date, int money, int interestRate, RecordType type) {
            this.date = date;
            this.money = Math.abs(money);
            this.interestRate = interestRate / 100.00;
            this.type = type;
        }

        public LocalDate getDate() {
            return date;
        }

        public int getMoney() {
            return money;
        }

        public boolean isDeposit() {
            return RecordType.DEPOSIT.equals(type);
        }

        public int calculate(Record withdrawalRecord) {
            int withdrawalAmount = withdrawalRecord.getMoney();
            if (money <= withdrawalAmount) {
                withdrawalAmount = money;
            }
            withdrawalRecord.completeWithdrawal(withdrawalAmount);
            return calculate(withdrawalAmount, withdrawalRecord.getDate());
        }

        private void completeWithdrawal(int completeWithdrawalMoney) {
            this.money -= completeWithdrawalMoney;
        }

        private int calculate(int withdrawalAmount, LocalDate withdrawalDate) {
            this.money -= withdrawalAmount;
            long days = ChronoUnit.DAYS.between(date, withdrawalDate);
            return (int) (withdrawalAmount * interestRate * (days / 365.00));
        }

        public int calculateAll() {
            return calculate(money, LAST_DAY_OF_YEAR);
        }
    }

    private enum RecordType {
        DEPOSIT, WITHDRAW;

        public static RecordType from(int money) {
            return money > 0 ? DEPOSIT : WITHDRAW;
        }
    }

}
