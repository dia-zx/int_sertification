# модуль интерфейса взаимодействия с пользователем

from os import system


# CommandList - список команд меню ["1 - Фильтр", "2 - Удалить", "3 - Добавить", "4 - Редактировать", ...]


def DrawMenu(CommandList: list):
    """Функция отрисовки меню."""
    print(CommandList)
    print("")


# Вывод строк заметок (items) БД в виде таблицы
# ╔════╦════════════════════╦══════════════════════════════╦══════════════════════════════════════════╗
# ║ ID ║   Дата изменения   ║          Заголовок           ║               Текст Заметки              ║
# ╠════╬════════════════════╬══════════════════════════════╬══════════════════════════════════════════╣
# ║ 1  ║     2023-02-21     ║          Заметка 1           ║             Это текстзаметки 1           ║
# ║ 2  ║     2023-02-21     ║          Заметка 2           ║            Это текст заметки 2           ║
# ╚════╩════════════════════╩══════════════════════════════╩══════════════════════════════════════════╝

def DrawItems(items: dict, filter: str):
    """Вывод таблицы БД на экран."""
    ColumnWidth = [4, 20, 30, 100]
    ColumnsTitle = ["ID", "Дата изменения", "Заголовок", "Текст Заметки"]
    # ****************** Заголовок таблицы **********************
    st = ""
    for it in ColumnWidth:
        st += "╦" + "═"*it
    st = "╔" + st[1:]
    st += "╗"
    print(st)

    st = ""
    for i in range(len(ColumnsTitle)):
        st += "║" + ColumnsTitle[i].center(ColumnWidth[i], " ")
    st += "║"
    print(st)

    st = ""
    for it in ColumnWidth:
        st += "╬" + "═"*it
    st = "╠" + st[1:]
    st += "╣"
    print(st)

    # ***************** Записи БД *****************************
    for key in items.keys():
        st = "║" + str(key).center(ColumnWidth[0])
        i = 1
        for key2 in items[key].keys():
            st += "║" + items[key][key2].center(ColumnWidth[i], " ")
            i += 1
        st += "║"
        print(st)

    # ***************** Нижняя строка таблицы   *****************
    st = ""
    for it in ColumnWidth:
        st += "╩" + "═"*it
    st = "╚" + st[1:]
    st += "╝"
    print(st)

    if filter != "":
        print(f"Действует фильтр вывода: {filter}")


def InputString(prompt: str):
    """Пользовательский ввод
    Возвращает строку текста, введенную пользователем
    prompt - строка текста, поясняющая ввод
    """
    return input(prompt)


def ClearScreen():
    """Функция очистки экрана."""
    system('cls||clear')
    print()
    print()