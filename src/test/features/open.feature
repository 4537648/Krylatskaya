# language: ru
Функция: Открытие сайта

  @Test
  Сценарий: Успешное открытие сайта
    * Проверить что в копирайте указана подпись "©2021 Krylatskaya"

  Структура сценария: <0> - Проверка главного меню на наличие пункта <Пункт>
    * Проверить наличие "<Пункт>" внутри "<Родитель>"

    Примеры:
      | 0 | Пункт       | Родитель |
      | 1 | Музыка      |          |
      | 2 | Facebook    |          |
      | 3 | Instagram   |          |
      | 4 | Youtube     |          |
      | 5 | VK          |          |
      | 6 | Email       |          |
      | 7 | KRYLATSKAYA | Музыка   |
      | 8 | APRIL RAIN  | Музыка   |

  @Test
  Сценарий: Проверка успешного входа в корпоративный раздел
    * Перейти в раздел "corp"
    * Ввести пароль ("успех")
    * Нажать на кнопку "Войти" ("успех")

  @Test
  Сценарий: Проверка неуспешного входа в корпоративный раздел
    * Перейти в раздел "corp"
    * Ввести пароль ("неуспех")
    * Нажать на кнопку "Войти" ("неуспех")
