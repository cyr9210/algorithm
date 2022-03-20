package com.bong.algorithm.test.kakao_bank;

import java.util.ArrayList;
import java.util.List;

public class Solution02 {

    private static final int BLACK = 1;
    private static final int WHITE = 2;
    private static final int UNDEFINED = 0;

    public int[] solution(int[] black_caps) {
        People people = new People();

        int firstBlackCount = black_caps[0];
        Person first = Person.first(firstBlackCount);
        people.add(first);
        Person before = first;
        for (int i = 1; i < black_caps.length; i++) {
            Person next = before.next(black_caps[i]);
            people.add(next);
            before = next;
        }
        people.check();
        people.checkIter();

        return people.getAnswer();
    }

    public static class Person {
        private int blackCount;
        private int color; // 0: 모름 1: 검은색 2:하얀색
        private Person before;
        private Person next;

        private Person(int blackCount, Person before) {
            this.blackCount = blackCount;
            this.color = 0;
            this.before = before;
        }

        public static Person first(int blackCount) {
            return new Person(blackCount, null);
        }

        public Person next(int blackCount) {
            Person next = new Person(blackCount, this);
            this.next = next;
            return next;
        }

        public Person getBefore() {
            return before;
        }

        public Person getNext() {
            return next;
        }

        public int getBlackCount() {
            return blackCount;
        }

        public int getColor() {
            return color;
        }

        private void complete(int color) {
            this.color = color;
        }

        private void beforeNextComplete(int color) {
            if (before != null && next != null) {
                before.complete(color);
                next.complete(color);
            }
        }

        public void checkUndefinedColor() {
            if (blackCount == 1) {
                if (before != null && next != null) {
                    if (before.color == BLACK && next.color == UNDEFINED) {
                        next.color = WHITE;
                    }
                    if (next.color == BLACK && next.color == UNDEFINED) {
                        before.color = WHITE;
                    }
                    if (before.color == WHITE && before.color == UNDEFINED) {
                        next.color = BLACK;
                    }
                    if (next.color == WHITE && before.color == UNDEFINED) {
                        before.color = BLACK;
                    }
                }
            }
        }
    }

    public static class People {
        private List<Person> people = new ArrayList<>();

        public void add(Person person) {
            people.add(person);
        }

        public List<Person> getPeople() {
            return people;
        }

        public void check() {
            checkFirst();
            checkLast();
        }

        private void checkFirst() {
            Person SecondPerson = people.get(1);
            if (people.get(0).getBlackCount() == 1) {
                SecondPerson.complete(BLACK);
            } else {
                SecondPerson.complete(WHITE);
            }
        }

        private void checkLast() {
            int lastIndex = people.size() - 1;
            Person LastSecondPerson = people.get(lastIndex - 1);
            if (people.get(lastIndex).getBlackCount() == 1) {
                LastSecondPerson.complete(BLACK);
            } else {
                LastSecondPerson.complete(WHITE);
            }
        }

        public void checkIter() {
            people.stream().filter(person -> person.getBlackCount() == 2).forEach(person -> person.beforeNextComplete(1));
            people.stream().filter(person -> person.getBlackCount() == 0).forEach(person -> person.beforeNextComplete(2));
            people.stream().forEach(person -> person.checkUndefinedColor());
        }

        public int[] getAnswer() {
            return people.stream().mapToInt(Person::getColor).toArray();
        }
    }


}
