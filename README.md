# itis-java-sem-2
Шаблонный репозиторий для курса "Информатика". 2 семестр.

[Инструкция](../master/git-tutorial.md#дополнение) для объединения вашего и шаблонного репозиториев.

* * *
# Полезные ссылки
- [Видеоурок по лямбда-выражениям](https://www.youtube.com/watch?v=WmMavkXMXDg), [вторая часть](https://www.youtube.com/watch?v=KSSW1YaW_vQ).
- [Параметры переменной длины](https://docs.oracle.com/javase/tutorial/java/javaOO/arguments.html#varargs)
- [Wildcards](https://docs.oracle.com/javase/tutorial/extra/generics/wildcards.html)

* * *

# Домашние задания
## Задание 1. 
Написать метод addStars, который получает в качестве параметра список строк (List<String>) и добавляет \* после каждого элемента. Менять нужно список переданный в качестве параметра. 
Написать обратный метод removeStars, который удаляет эти звездочки. На входе должен быть список каждый второй элемент которого \*. Метод должен также проверять это условие.

## Задание 2. 
Написать метод intersect, принимающий два списка в качетсве параметра и выводит только те элементы, которые есть в обоих списках. Добавить проверку на тип элементов.
  
## Задание 3. 
Написать следующую программу: на входе текстовый файл с английским текстом. 
+ Написать метод считывающий текст из файла в список ArrayList.
+ Метод capitalizePlurals принимающий ArrayList строк, и заменяет каждое слово заканчивающееся на букву "s" на версию с заглавными буквами. 
+ Метод removePlurals удаляющий все слова, которые заканчиваются на букву "s", регистронезависимо.
+ Результат выполнения вывести на экран.

## Задание 4. 
Реализовать ввод и вывод односвязного линейного списка. Ввод реализовать в прямом порядке. 

## Задание 5. 
Для введенного односвязного линейного списка найти максимум, сумму элементом, а также проверить в нем наличие отрицательных чисел. Все три задачи - методами.
Вводится линейный односвязный список
  
## Задание 6. 
К заданиям 4-5 добавить следующие методы:
+ Удалить голову списка
+ Удалить последний элемент списка
+ Удалить предпоследний элемент списка
+ Удалить из списка первый встретившийся элемент, равный k.
+ Удалить из списка все элементы, равные k.
+ Вставить число m до и после первого элемента, равного k.
*В заданиях 4-6 не использовать готовые методы.*

## Задание 7. 
Реализовать класс ArrayCollection<T> implements Collection<T> (коллекция с реализацией в виде массива)

## Задание 8. 
Реализовать класс LinkedCollection<T> implements Collection<T> (коллекция с реализацией в виде линейного списка)
*Реализовать только необходимые методы (не те, для которых в интерфейсе есть default реализация - т.е те, без которых класс не сможет быть неабстрактным).
В задачах 7 и 8 приветствует наличие промежуточного абстрактного класса, реализующего поведение методов, работа которых не зависит от реализации (addAll, containsAll и др), от которого наследуются два ваших класса.*

## Задание 9. 
Реализовать класс ArrayList<T> implements List<T> (список с реализацией в виде массива)

## Задание 10. 
Реализовать класс LinkedList<T> implements List<T> (список с реализацией в виде односвязного линейного списка)
*Реализовать только необходимые методы (не те, для которых в интерфейсе есть default реализация - т.е те, без которых класс не сможет быть неабстрактным)
В задачах 9 и 10 приветствует наличие промежуточного абстрактного класса, реализующего поведение методов, работа которых не зависит от реализации (addAll, containsAll и др), от которого наследуются два ваших класса.*

*~~До 4 марта.~~ До 18 марта.*
---

## Задание 11.
Добавить в [Задание 3.](#задание-3) методы подсчета уникальных слов используя ArrayList, TreeSet, HashSet. Сравнить результаты используя ```long start = System.currentTimeMillis();```.
Реализовать метод подсчета частоты слов используя класс TreeMap или HashMap, вывести топ-50 самых встречаемых слов.
Словом считать любой набор букв разделенный пробелами или небуквенными символами. Регистр не учитывать.
Рекомендуется взять большой английский текст, например, [этот](../master/JavaLessonsProject/mobydick.txt).

## Задание 12. 
Добавить в [Задание 4.](#задание-4) метод addSort, добавляющий новый элемент в подходящее, отсортированное место. Список считать отсортированным, можете добавить проверку по желанию.

## Задание 13. 
Реализовать класс ArrayStack<T> и LinkedStack<T> с методами стека push, pop, peek и isEmpty.

## Задание 14.
Реализовать классы ArrayQueue<T> и LinkedQueue<T>, реализующие интерфейс Queue<T>.

## Задание 15.
Проверить правильность расстановки скобок в строке используя несколько видов скобок - со стеком. Информативно выводить пользователю, в чем заключается его ошибка.

*~~До 11 марта.~~ До 18 марта.*

---

## Задание 16.
Реализовать класс DoubleStackQueue<T>, реализующий интерфейс Queue<T>, использующий для моделирования очереди два стека внутри себя. Решить с его помощью задачу # 15, случай б.

## Задание 17.
Вычислить с помощью стека арифметическое выражение, записанное в виде постфиксной записи в строке: например, значение “10, 15 +, 20, \*” будет равно 500. При задании данных используйте параметры переменной длины (varargs). 

## Задание 18.
Разработать класс HtmlTag с атрибутами String name и boolean isOpenTag.  Реализовать все возможные конструкторы, (гет/сет)теры и метод toString. Также реализовать метод equals(Object other), выдающий true, если элемент содержит тот же тип и значение, что и параметр. Имплементируйте интерфейс Comparable и отсортируйте элементы Collection<HtmlTag> по названию элементов, для элементов с одинаковым названием сперва идет открывающий тег потом закрывающий.
Пример выполнения.
```java 
// <body><b></b><i><b></b><br/></i></body>
Set<HtmlTag> tags = new TreeSet<HtmlTag>();
tags.add(new HtmlTag("body", true)); // <body>
tags.add(new HtmlTag("b", true)); // <b>
tags.add(new HtmlTag("b", false)); // </b>
tags.add(new HtmlTag("i", true)); // <i>
tags.add(new HtmlTag("b", true)); // <b>
tags.add(new HtmlTag("b", false)); // </b>
tags.add(new HtmlTag("br")); // <br />
tags.add(new HtmlTag("i", false)); // </i>
tags.add(new HtmlTag("body", false)); // </body>
System.out.println(tags);
// [<b>, </b>, <body>, </body>, <br />, <i>, </i>]
```

## Задание 19.
Реализовать класс Student с атрибутами fio, year, city, averageScore. Создать список студентов (java.util.ArrayList), который можно будет отсортировать по всем перечисленным параметрам. Использовать Comparable, Comparator (как класс, как анонимный класс, как лямбда-выражение) - по 1 случаю на каждый атрибут.

## Задание 20.
Добавить в [Задание 11.](#задание-11) подсчет слов используя коллекцию типа Map, в ключ записывать слова, в значения их количество. Считать с файла в наиболее подходящую, по Вашему мнению, коллекцию список [стопслов](https://github.com/stopwords-iso/stopwords-en/blob/master/stopwords-en.txt), не добавлять в словарь эти слова. Вывести 50 самых часто используемых слов вместе с их количеством. 

*До 18 марта.*

---

# Подготовка к Контрольной работе №1
Будет 4 **письменных** задания. Всего на кр выделено 10 баллов. 
Для удобаства оценивания, максимальный балл равен 50, который будет разделен по коэффициенту.
Опечатки в синтаксисе не учитываются.
На кр будут задания по этим же темам.

## КР 1.1. (10 баллов)
**Наследования/Полиморфизм.** Представьте, что у вас есть следующие классы: 
```java
public class Clock extends Bear {
    public void method3() {
        System.out.println("Clock 3");
    }
}
public class Lamp extends Can {
    public void method1() {
        System.out.println("Lamp 1");
    }
    public void method3() {
        System.out.println("Lamp 3");
    }
}
public class Bear extends Can {
    public void method1() {
        System.out.println("Bear 1");
    }
    public void method3() {
        System.out.println("Bear 3");
        super.method3();
    }
}
public class Can {
    public void method2() {
        System.out.println("Can 2");
        method3();
    }
    public void method3() {
        System.out.println("Can 3");
    }
}
```
И заданы следующие переменные:
```java
    Object var1 = new Bear();
    Can var2 = new Can();
    Can var3 = new Lamp();
    Bear var4 = new Clock();
    Object var5 = new Can();
    Can var6 = new Clock();
``` 
Заполните следующую таблицу:
| Выражение                | Результат   |
|--------------------------|-------------|
| var1.method2();          | ___________ |
| var2.method2();          | ___________ |
| var3.method2();          | ___________ |
| var4.method2();          | ___________ |
| var5.method2();          | ___________ |
| var1.method3();          | ___________ |
| var2.method3();          | ___________ |
| var3.method3();          | ___________ |
| var6.method3();          | ___________ |
| ((Lamp)var6).method1();  | ___________ |
| ((Can)var1).method1();   | ___________ |
| ((Can)var1).method2();   | ___________ |
| ((Bear)var1).method3();  | ___________ |
| ((Clock)var1).method1(); | ___________ |
| ((Clock)var4).method2(); | ___________ |

Если результатов больше одной строки, разделяйте их слешами ("/").
Если вылезет ошибка, пишите  "compiler error" или "runtime error".

## КР 1.2. (10 баллов)
**Comparable.** Реализуйте класс PokemonTrainer, который хранит информацию о тренере покемонов и количество 
выигранных боев. Каждый объект PokemonTrainer хранит имя тренера, количество ачивок, общее число боев и число
победных боев.

```java
 PokemonTrainer(String name, int badges) // конструктор содержит имя и число ачивок, при этом число боев равно 0.

 getBadges() // выводит число ачивок

 getBattlePercent() 
/*  выводит вещественное число процента выигрыша. 
    Если тренер выиграл все бои, то должно вернуть число 100.0, 
    если проиграл все или еще не играл, то 0.0. */

 battle(boolean won) // записывает тренеру бой, true если выиграл, false в противном случае.
 toString() 
/*  выводит строку с именем, чилом ачивок и процентом выигрышей (или "боев не было"). 
    Процент боев нужно округлить, т.е. если процент равен 73.835, то нужно вывести 73%.
*/
```

Пример тестового запуска:
```java
 PokemonTrainer trainer1 = new PokemonTrainer("Sam", 1);
 PokemonTrainer trainer2 = new PokemonTrainer("Anika", 6);

 trainer2.getBadges(); // returns 6
 trainer1.battle(true); // records a battle win for trainer1
 trainer1.battle(false); // records a battle loss for trainer1
 trainer1.getBattlePercent(); // returns 50.0
 trainer2.getBattlePercent(); // returns 0.0
 trainer1.battle(false); // records a battle loss for trainer1
 trainer1.getBattlePercent(); // returns 33.3333333333333333
 trainer1.toString(); // returns "Sam has 1 badge(s) and a 33% win rate"
 trainer2.toString(); // returns "Anika has 6 badge(s) and no battles"

```

Класс PokemonTrainer должен быть сопоставим с другими объектами PokemonTrainer 
и должен реализовывать интерфейс Comparable. 
Тренеров необходимо отсортировать в порядке возрастания по проценту сражений.
Вы должны использовать полное значение процента битвы, а не усеченное. 
Тренеры с одинаковым процентом сражений должны быть упорядочены по количеству сыгранных сражений, 
причем тренеры, которые сражались чаще, считались «меньше», чем тренеры, которые сражались реже. 
Если все еще есть ничья, тренеры должны быть отсортированы в алфавитном порядке по имени.

## КР 1.3. (15 баллов)
**Коллекции.** Написать метод recordDate, который выдает информацию о свиданиях между двумя людьми.
Для каждого человека задается список типа Map, который хранит упорядоченный список людей, 
с которыми данный человек уже встречался.
Например, список должен хранить следующие записи для двух людей:
``` 
Michael => [Ashley, Samantha, Joshua, Brittany, Amanda, Amanda]
Amanda => [Michael, Daniel, Michael]
```
Свидания отсортированы в обратном порядке. В примере Майкл последний раз встречался с Эшли, а до этого с Самантой итд.
Обратите внимание, что с Амандой он встречался дважды. Все имена хранятся как строки.
Метод имеет три аргумента: список типа Map, и имена двух людей. Метод должен добавить запись в список для каждого человека
 и вывести число равное количеству свиданий. Таким образом, если мы выполним следующий код для состояния выше:
```java 
 int n = recordDate(dates, "Michael", "Amanda");
```
то должны получить такой результат:
```
  Michael => [Amanda, Ashley, Samantha, Joshua, Brittany, Amanda, Amanda]
  Amanda => [Michael, Michael, Daniel, Michael]
```
Метод выдаст число 3, сообщяющий что это третье свидание. 
Когда кто-то появляется впервые, вы должны использовать объект LinkedList 
(здесь используем LinkedList вместо ArrayList, т.к. он имеет более быстрый ввод в начало списка).

***ЗЫ** Под человеком подразумевается обычная строка с его именем.* 

***ЗЫЫ** Нельзя использовать методы функционального программирования (лямбды итп.).*

## КР 1.4. (15 баллов)
**Связные списки.** Написать метод rearrange, который переставляет порядок списка целочисленных чисел таким образом, что 
все значения на четных позициях встанут в обратном порядке в начале списка, а нечетные в конце списка в прямом порядке.
Например, ```[0, 1, 2, 3, 4, 5, 6, 7, 8, 9] => [8, 6, 4, 2, 0, 1, 3, 5, 7, 9]```.

В примере значения соответсвуют позициям, однако это не обязательное условие, список может быть произвольным.

Если в списке менее двух элементов, он должен вернуться без изменений.

Ваша задача написать метод класса LinkedIntList. Вы можете добавить приватные, вспомогательные методы,
однако вы не можете предполагать, что какие-либо конкретные методы доступны. Вам разрешено определять свои собственные 
переменные типа ListNode, но вы не можете создавать какие-либо новые узлы. Также вы не можете использовать какую-либо 
вспомогательную структуру данных для решения этой проблемы (без массива, ArrayList, стека, очереди, String и т. д.). 
Вы также не можете изменять какие-либо поля данных узлов. Вы ДОЛЖНЫ решить эту проблему, переставив ссылки в списке.
Ваше решение должно выполняться за время O (n), где n - длина списка.

Структура классов представлена ниже:
```java
 public class ListNode {
     public int data; // здесь хранятся данные
     public ListNode next; // ссылка на следующий элемент
     <constructors>
 }
 public class LinkedIntList {
     private ListNode front; // первый элемент списка
     <methods>
 }
```



*До 16 марта, я не буду оценивать эти задания, решайте их для подготовки к контрольной работе. 
В понедельник обсудим возникшие по ним вопросы.*

---

## Задание 21.
Решить задачу расстановки 8 королев на шахматной доске, используя рекурсивный метод отката.

Реализуйте класс Board, со следующими методами:
+ public Board(int size)  // конструктор
+ public boolean isSafe(int row, int column) // true если королева может быть безопасно поставлена на ячейку с номером
+ public void place(int row, int column) // поставить королеву сюда
+ public void remove(int row, int column) // убрать королеву отсюда
+ public String toString() // отобразить доску в текстовом виде
Напишите метод solveQueens, который принимает Board в качестве параметра, и безопасно устанавливает 8 королев.

## Задание 22.
Как сделать из мухи слона. Реализовать игру цепочки слов, задача игроков — превратить одно слово в другое с наименьшим количеством промежуточных звеньев. Например, МУХА — МУРА — ТУРА — ТАРА — КАРА — КАРЕ — КАФЕ — КАФР — КАЮР — КАЮК — КРЮК — УРЮК — УРОК — СРОК — СТОК — СТОН — СЛОН.

К заданию прилагается [словарь](../master/JavaLessonsProject/src/sem2/dict_len4.txt) слов состоящих из 4 букв.

Дополнительные два балла тому кто решит задачу наиболее оптимальным образом. Для оценки можете использовать статичный счетчик и время выполнения.
