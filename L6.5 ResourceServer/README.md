## **_Задача:_**

Добавить в сервер класс resources.TestResource
```java
  public class TestResource {
    private String name;
    private int age;

    public TestResource(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public TestResource() {
        this.name = "";
        this.age = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
```
Написать ResourceServer, который будет содержать ссылку на TestResource.

Вывести ResourceServer в JMX с именем:

      Admin:type=ResourceServerController

Сделать переменные "name" и "age" доступными для чтения из jmx клиента.

Написать сервлет, который будет обрабатывать запросы на /resources.

При получении POST запроса с параметром path=path_to_resource
прочитает ресурс TestResource из указанного в параметре файла и сохранит ссылку в ResourceService.

После чтения, значения name и age должны быть доступны по JMX.

## Во время проверки тестовая система:

Запустит ваш сервер, подождет пока "Server started".

Создаст файл resource.xml в локальной файловой системе.

Пришлет по POST запросу имя этого файла в сервер, проверит через JMX, что значение name и age совпадают с записанными
