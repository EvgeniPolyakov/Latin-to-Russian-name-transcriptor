# Latin to Russian name transcriptor

**L2R Name transcriptor** is a tool for converting proper name spellings from Latin script to Cyrillic script. It turns
proper name spelling from Latin script to Cyrillic script using standard spelling system of respective language.

You can access the tool through
a [basic user-friendly GUI](http://l2rfrontend-env.eba-jyypjt3v.eu-north-1.elasticbeanstalk.com/) or utilize the API (
details provided in the specification below).

## Features

**L2R** supports over 30 languages, including non-Roman alphabet-based languages such as Greek and Chinese, with new
languages added regularly. Full list can be found below.

The tool primarily transcribes proper names (such as personal or geographical names) and can handle words in lower case,
Title case, and ALLCAPS. Words in MiXeD case are automatically cast to Title case.

Automatic transcription by its very nature can not offer flawless result at all times but the goal is to provide results
that are as close to the correct spelling as possible.

For languages that do not use a Latin-based alphabet, the app transcribes names based on their Latin spelling, so it may
not accurately reflect the original spelling or any special rules for transcribing from the original language to
Russian.

By default, the app does not use the letter "ё" when transcribing into Russian (it is replaced with "e"), but there is a
dedicated mode for certain languages where this letter is used.

List of currently supported languages:

* 🇷🇺 Russian (from Roman script back to Cyrillic)
* 🇦🇱 Albanian
* 🇦🇲 Armenian (from Roman script to Cyrillic)
* 🇦🇿 Azeri (from English transcription to Cyrillic)
* 🇧🇷 Brazilian Portuguese
* 🇧🇬 Bulgarian (from Roman script back to Cyrillic)
* 🇨🇳 Chinese (from Roman script to Cyrillic)
* 🇨🇿 Czech
* 🇳🇱 Dutch
* 🇪🇪 Estonian
* 🇫🇮 Finnish
* 🇫🇷 French
* 🇮🇱 Hebrew (from Roman script to Cyrillic)
* 🇭🇺 Hungarian
* 🇬🇪 Georgian (from Roman script to Cyrillic)
* 🇩🇪 German
* 🇬🇷 Greek (from Roman script to Cyrillic)
* 🇮🇹 Italian
* 🇯🇵 Japanese (from Hepburn romanization system to Cyrillic)
* 🇱🇹 Lithuanian
* 🇱🇻 Latvian
* 🇲🇰 Macedonian (from Roman script back to Cyrillic)
* 🇵🇱 Polish
* 🇵🇹 Portuguese
* 🇷🇴 Romanian / 🇲🇩 Moldovan
* 🇷🇸🇭🇷 Serbo-Croatian
* 🇸🇰 Slovak
* 🇪🇸 Spanish
* 🇹🇷 Turkish
* 🇺🇦 Ukrainian (from Roman script back to Cyrillic)

Any feedback is kindly welcome.

## API

[Swagger specification (JSON format)](https://raw.githubusercontent.com/EvgeniPolyakov/L2R-name-transcriptor/main/api-description.json)

## Launch

Docker container can be built and launched by:

1. cloning this project
2. installing and running Docker (if it has been not already installed)
3. running container in the terminal by command: `docker-compose up`

---

---

# Транскриптор имен с латиницы на русский

**Транскриптор L2R** - это инструмент орфографической транскрипции на русский. Он переводит написание имен собственных с
латиницы на кириллицу, используя стандартную систему транскрипции для соответствующих языков.

Инструмент доступен
через [базовый графический интерфейс](http://l2rfrontend-env.eba-jyypjt3v.eu-north-1.elasticbeanstalk.com/), или можно
использовать API (подробности приведены в спецификации ниже).

## Рабочие характеристики

**L2R** транскрибирует с языков, использующих алфавиты на основе латиницы, но также поддерживает транскрипцию с латиницы
на русский для ряда языков, которые используют иные алфавиты и системы письменности (например, греческий или китайский).
Приложение поддерживает более 30 языков. Полный пречень доступен ниже.

Поскольку приложение в первую очередь предназначено для транскрипции имен собственных (например, личных имен или
географических названий), оно подразумевает, что те приходят в одном из трех стандартных регистров: строчными буквами, с
Прописной буквы или полностью ПРОПИСНЫМИ. Слова в СмЕшАнНом регистре автоматически приводятся к формату с одной
прописной.

Автоматическая транскрипция по своей сути не может гарантировать безупречную транскрипцию во всех случаях, но стремится
к этому в пределах возможного. Список частных случаев и исключений для различных языков, не поддерживаемых
транскриптором L2R, можно
найти [здесь](https://github.com/EvgeniPolyakov/L2R-name-transcriptor/blob/main/docs/CustomCases.md).

При работе с языками, не использующими алфавит на основе латинского, программа транскрибирует имена на основе их
написания латиницей и не способна учитывать тонкости изначального правописания таких слов и/или другие особые правила
их передачи на русский с языка оригинала.

По умолчанию программа не использует букву "ё" при транскрипции на русский (заменяется на "е"), но для отдельных языков
предусмотрен отдельный режим транскрипции с её передачей.

Список поддерживаемых на данный момент языков:

* 🇷🇺 русский (с транслита/латиницы на кириллицу)
* 🇦🇱 албанский
* 🇦🇲 армянский (с латиницы на кириллицу)
* 🇦🇿 азербайджанский (с английской транскрипции на русский)
* 🇧🇬 болгарский (с латиницы на кириллицу с транскрипцией на русский)
* 🇧🇷 бразильский португальский
* 🇭🇺 венгерский
* 🇬🇷 греческий (с латиницы на кириллицу)
* 🇬🇪 грузинский (с латиницы на кириллицу)
* 🇮🇱 иврит (с латиницы на кириллицу)
* 🇪🇸 испанский
* 🇮🇹 итальянский
* 🇨🇳 китайский (с латиницы на кириллицу по системе Палладия)
* 🇱🇻 латышский
* 🇱🇹 литовский
* 🇲🇰 македонский (с латиницы на кириллицу с транскрипцией на русский)
* 🇩🇪 немецкий
* 🇳🇱 нидерландский
* 🇵🇱 польский
* 🇵🇹 португальский
* 🇷🇴 румынский / 🇲🇩 молдавский
* 🇷🇸🇭🇷 сербохорватский
* 🇸🇰 словацкий
* 🇹🇷 турецкий
* 🇺🇦 украинский (с латиницы на кириллицу с транскрипцией на русский)
* 🇫🇷 французский
* 🇫🇮 финский
* 🇨🇿 чешский
* 🇪🇪 эстонский
* 🇯🇵 японский (с латиницы по системе Хэпберна на кириллицу)

Приветствуется любая обратная связь.

## API

[Swagger спецификация (в формате JSON)](https://raw.githubusercontent.com/EvgeniPolyakov/L2R-name-transcriptor/main/api-description.json)

## Запуск

Чтобы запустить Docker-контейнер, надо:

1. склонировать проект
2. установить и запустить Docker (если не установлен ранее)
3. запустить контейнер в терминале посредством команды: `docker-compose up`
