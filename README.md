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
[Тестовый билет контрольной работы](cw_1_0.md)


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

К заданию прилагается [словарь](../master/JavaLessonsProject/src/sem2/dict_len4.txt) слов, состоящих из 4 букв.

Дополнительные два балла тому, кто решит задачу наиболее оптимальным образом. Для оценки можете использовать статичный счетчик и время выполнения.

~~До 30.03.~~ До 6 апреля.

## Задание 23.
Решить все упражнения из [L7](DistanceEducation/L7.md) и [L8](DistanceEducation/L8.md).

До 25.03.

## Задание 24.
### Реализовать класс ориентированного графа.
####  Три части по одному баллу. 
[Есть](https://ru.wikipedia.org/wiki/%D0%93%D1%80%D0%B0%D1%84_(%D0%BC%D0%B0%D1%82%D0%B5%D0%BC%D0%B0%D1%82%D0%B8%D0%BA%D0%B0)#.D0.A1.D0.BF.D0.BE.D1.81.D0.BE.D0.B1.D1.8B_.D0.BF.D1.80.D0.B5.D0.B4.D1.81.D1.82.D0.B0.D0.B2.D0.BB.D0.B5.D0.BD.D0.B8.D1.8F_.D0.B3.D1.80.D0.B0.D1.84.D0.B0_.D0.B2_.D0.B8.D0.BD.D1.84.D0.BE.D1.80.D0.BC.D0.B0.D1.82.D0.B8.D0.BA.D0.B5)
несколько вариантов реализаций графа:
+ Список смежности
+ Матрица смежности
+ Матрица инцидентности

##### Часть 1
Своими словами опишите все три подхода (одно-два предложения в качестве комментария в начале класса), 
а также другой подход, если вы будете использовать его.

Добавьте в начале классов Abstraction Functions и Rep Invariants (см., напр., [тык](https://web.mit.edu/6.005/www/fa15/classes/13-abstraction-functions-rep-invariants/), [тык](https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-170-laboratory-in-software-engineering-fall-2005/lecture-notes/lec8.pdf)),
отображающие какие типы данных используются внутри классов.

Добавьте комментарии над каждым методом, отображающий его суть.

Реализуйте метод `private checkRep()`, который проверяет описанный *Rep Invariants* и выбрасывает исключение, если оно не выполняется.

##### Часть 2
Напишите модульные тесты для каждого публичного метода ваших классов.
Попробуйте использовать стратегию TDD.
Также напишите комментарии к тестам о вашей стратегии.

##### Часть 3 
Реализуйте классы графа.

## Задание 25. MarvelPaths
В этом задании вам необходимо, в разработанный в задании 24 граф добавить 
моделирование вселенной Марвел.
Данное приложение строит граф содержащий тысячи узлов и граней.

В этом приложении ваш граф моделирует социальную сеть среди персонажей комиксов Marvel. 
Каждый узел в графе представляет одного персонажа, и ребро ?Char1, Char2? указывает, 
что Char1 появился в комиксе, в котором также появился Char2. 
Для каждого комикса должно быть отдельное ребро, помеченная названием книги.
 Например, если бы Зевс и Геркулес появились в (скажем) пяти выпусках данной серии, 
 то у Зевса было бы пять ребер к Геркулесу, а у Геркулеса было бы пять ребер к Зевсу.
 
 Ваш граф не должен ссылаться на себя.
 
Необходимо реализовать класс MarvelPaths, который считывает данные Marvel из файла (marvel.csv),
 строит график и находит пути между персонажами в графе.
 Пример:
``` 
 path from GORILLA-MAN to VENUS-II:
 GORILLA-MAN to HAWK via AVF-4
 HAWK to VENUS-II via AVF-5
 ```
 
*Формат CSV – это таблица разделелнная SEPARATOR-ом (в зависимости от региона он разный, например,
в России это ";", тогда как в США ",". Указывается в системных настройках локали). 
Также можно указать первой строкой какой использовать разделитель (например, SEP=,).
Также возможно использование кавычек, для определения начала и конца.*

Строка выглядит следующим обрам: `"character","book""`, где `character` - имя персонажа, а
`book` - название коммикса, в которой был этот персонаж.

Первым шагом необходимо разработать класс `MarvelParser`, с единственным статичным методом
`parseData(String filename, Set <String> characters, Map<String, List<String>> books)`. 
Который считывает данные с файла, и записывает в переданные параметры. В `Set` всех персонажей,
а в `Map` в ключи название книги и список персонажей в значения.

Ваша программа должна найти кратчайший путь, используя алгоритм поиска в ширину (BFS).

Всевдокод:
```
    start = starting node
    dest = destination node
    Q = queue, or "worklist", of nodes to visit: initially empty
    M = map from nodes to paths: initially empty.
        // Each key in M is a visited node.
        // Each value is a path from start to that node.
        // A path is a list; you decide whether it is a list of nodes, or edges,
        // or node data, or edge data, or nodes and edges, or something else.
    Add start to Q
    Add start->[] to M (start mapped to an empty list)
    while Q is not empty:
        dequeue next node n
        if n is dest
            return the path associated with n in M
        for each edge e=?n,m?:
            if m is not in M, i.e. m has not been visited:
                let p be the path n maps to in M
                let p' be the path formed by appending e to p
                add m->p' to M
                add m to Q
    If the loop terminates, then no path exists from start to dest.
    The implementation should indicate this to the client.
```

Ваша программа должна построить граф и найти путь менее чем за 30 секунд. 

Для тестирования можете использовать другой набор данных.

До 8 апреля.

## Задания 26. IO & NIO
1. Написать метод, копирующий один текстовый файл в другой. 
В качестве параметров использовать `Reader/Writer`.
Перегрузить метод с параметрами `Path`.
Не использовать метод `Files.copy()`.
2. Написать метод, считающий число вхождений символа (например, `e`), в файле. 
Использовать классы `Paths` и `Files`.
3. Написать метод с двумя параметрами `Path` так, что если в первом (уровень вложенности не 
более 2) содержится второй - удалить его, иначе создать.
Красиво, с отступами вывести на экран как было и как стало.
Например:
```text
Before:
foo
    bar
        bar1
        bar
    baz
After:
foo
    baz
```
4. Написать метод replaceFileLineStartsWith, заменяющий текст в начале строки.
Первый параметр регулярное выражение искомой строки,
 второй строка на которое стоит заменить, третий путь к файлу (Path).
Для работы с файлом использовать метод `Files.readAllLines` и `Files.write`.
Для примера можно взять удаление перечисления.
Например, `replaceFileLineStartsWith("regex find digits and symbol/space after", "", file)`.
```text
1. public class Main {
2.     public static void main(String[] args) {
3.         System.out.println("Hello, World!");
4.     }
5. }
```

## Задание 27. Reflection & Annotations

##### 1. 
Написать метод с параметрами класс и название пакета, если класс из данного пакета,
красиво вывести все (втч приватные) поля, конструкторы и методы без полного имени.

##### 2.
Реализовать аннотацию `@CsvBindByName`, с параметрами `String column`, `String capture` и `boolean required`.
Все поля с `default` значениями пустая строка/false. 
Первый параметр задает название столбца, 
второй – строка с регулярным выражением, соответствующий маске элемента,
последний - обязательное ли поле.

А также `@CsvBindByPosition`, с единственным параметром `int position`, определяющий номер столбца в файле.
    
Реализовать класс Visitor с тремя полями String username, int visitsToWebsite, long lastVisitTime.
Со всеми геттерами/сеттерами, а также реализовать оверрайд методы `toString`, `equals` (по логину) и `hashCode`.
Время задано в формате `"yyyy-mm-dd hh:mm:ss"`.

В классе Visitor для каждого поля указать созданные аннотации.
Имя столбца, для времени регулярное выражение, все поля объявить обязательными.
Также добавить номер столбца.

Реализовать класс CSVObjectReader<T> считывающий csv-файл в список объектов типа T.

Данные записывать в список объектов Visitor, учитывая указанные аннотации.
Приоритетом брать по названию, если не указано, то по номеру столбца.
Иначе выводить InputMismatchException. 

Также добавить проверку на валидность csv-файла (например, число столбцов не меняется).
 
Пример файла:
```csv
SEP=,
username, visitsToWebsite, lastVisitTime
john_doe, 10, "2020-02-21 19:21:12"
mark_aurelius123, 1, "2020-03-21 01:12:54"
```

*Использование `SEP=,` позволяет открыть файл в Excel-е, в виде таблицы, т.к. в РФ стандартный
 разделитель ";".*
 
Полученные данные сохранить в json, используя аннотацию, 
присвоить следующие имена полей: `name, visits, last`.