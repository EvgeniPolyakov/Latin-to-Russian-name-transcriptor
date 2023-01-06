# Latin to Russian name transcriptor

**L2R Name transcriptor** is a tool for proper name orthographic transcription from various Latin-script using languages
into Russian. It turns proper name spelling from Latin script to Cyrillic script using standard spelling system of
respective language. L2R also supports Latin to Russian transliteration for a few non-Roman alphabet based languages
like Greek or Chinese. Full list can be found below.

**Name transcriptor** is a project in process. As for now it presents only the back-end logics for name transcription.
Basic GUI support will be introduced at a later point. At this time app supports more than 20 languages and new ones are
added on a weekly basis.

## Features

Since service is primarily intended to transcribe proper names (like personal or geographical names) it implies words
are provided in either of three conventional character cases: lower case, Title case and ALLCAPS. Words in MiXeD case
are automatically cast to Title case.

Automatic transcription by its very nature can not offer flawless result at all times but aims to be as close to it as
possible.

When working with languages that do not use Latin-based alphabets, app transcribes names on the basis of spelling given
in Latin, so it is unable to respect custom aspects of the original spelling and/or other special rules of transcription
from the respective language to Russian.

By default, app does not use letter "ё" when transcribing into Russian (replaced by "e"), but for certain languages
there is a dedicated transcription mode for this purpose.

List of currently supported languages:

* 🇷🇺 Russian (from Roman script back to Cyrillic)
* 🇦🇱 Albanian
* 🇦🇲 Armenian (from Roman script to Cyrillic)
* 🇧🇷 Brazilian Portuguese
* 🇧🇬 Bulgarian (from Roman script back to Cyrillic)
* 🇨🇳 Chinese (from Roman script to Cyrillic)
* 🇨🇿 Czech
* 🇪🇪 Estonian
* 🇫🇷 French
* 🇬🇪 Georgian (from Roman script to Cyrillic)
* 🇩🇪 German
* 🇬🇷 Greek (from Roman script to Cyrillic)
* 🇯🇵 Japanese (from Hepburn romanization system to Cyrillic)
* 🇱🇹 Lithuanian
* 🇱🇻 Latvian
* 🇲🇰 Macedonian (from Roman script back to Cyrillic)
* 🇵🇹 Portuguese
* 🇷🇴 Romanian / 🇲🇩 Moldovan
* 🇷🇸🇭🇷 Serbo-Croatian
* 🇸🇰 Slovak
* 🇹🇷 Turkish
* 🇺🇦 Ukrainian (from Roman script back to Cyrillic)

Any feedback is kindly welcome.

## API

[Swagger specification (JSON format)](https://raw.githubusercontent.com/EvgeniPolyakov/L2R-name-transcriptor/main/api-description.json)

## Launch

App can be launched by compiling and installing it via standard Maven procedure.

---

---

# Транскриптор имен с латиницы на русский

**Транскриптор L2R** - это инструмент орфографической транскрипции на русский. Он транскрибирует с языков, использующих
алфавиты на основе латиницы, но также поддерживает транскрипцию с латиницы на русский для ряда языков, которые
используют иные алфавиты и системы письменности (например, греческий или китайский). Он переводит написание имен
собственных с латиницы на кириллицу, используя стандартную систему транскрипции для соответствующих языков.

**Транскриптор L2R** все еще находится в стадии разработки. На данный момент он представляет только внутреннюю логику
транскрипции имен. Базовый графический интерфейс будет представлена позже. На данный момент приложение поддерживает
более двух десятков языков. Новые языки добавляются еженедельно. Полный пречень доступен ниже.

## Рабочие характеристики

Поскольку приложение в первую очередь предназначено для транскрипции имен собственных (например, личных имен или
географических названий), оно подразумевает, что те приходят в одном из трех стандартных регистров: строчными буквами, с
Прописной буквы или полностью ПРОПИСНЫМИ. Слова в СмЕшАнНом регистре автоматически приводятся к формату с одной
прописной.

Автоматическая транскрипция по своей сути не может гарантировать безупречную транскрипцию во всех случаях, но стремится
к этому в пределах возможного. Список частных случаев и исключения для различных языков, не поддерживаемых
транскриптором L2R, можно
найти [здесь](https://github.com/EvgeniPolyakov/L2R-name-transcriptor/blob/main/docs/CustomCases.md).

При работе с языками, не использующими алфавит на основе латинского, программа транскрибирует имена на основе имеющегося
написания (латиницей) и не способна учитывать тонкости изначального правописания таких слов и/или другие особые правила
их передачи на русский с языка оригинала.

По умолчанию программа не использует букву "ё" при транскрипции на русский (заменяется на "е"), но для отдельных языков
предусмотрен отдельный режим транскрипции с её передачей.

Список поддерживаемых на данный момент языков:

* 🇷🇺 русский (с транслита/латиницы на кириллицу)
* 🇦🇱 албанский
* 🇦🇲 армянский (с латиницы на кириллицу)
* 🇧🇬 болгарский (с латиницы на кириллицу с транскрипцией на русский)
* 🇧🇷 бразильский португальский
* 🇬🇷 греческий (с латиницы на кириллицу)
* 🇬🇪 грузинский (с латиницы на кириллицу)
* 🇨🇳 китайский (с латиницы на кириллицу по системе Палладия)
* 🇱🇻 латышский
* 🇱🇹 литовский
* 🇲🇰 македонский (с латиницы на кириллицу с транскрипцией на русский)
* 🇩🇪 немецкий
* 🇵🇹 португальский
* 🇷🇴 румынский / 🇲🇩 молдавский
* 🇷🇸🇭🇷 сербохорватский
* 🇸🇰 словацкий
* 🇹🇷 турецкий
* 🇺🇦 украинский (с латиницы на кириллицу с транскрипцией на русский)
* 🇫🇷 французский
* 🇨🇿 чешский
* 🇪🇪 эстонский
* 🇯🇵 японский (с латиницы по системе Хэпберна на кириллицу)

Приветствуется любая обратная связь.

## API

[Swagger спецификация (в формате JSON)](https://raw.githubusercontent.com/EvgeniPolyakov/L2R-name-transcriptor/main/api-description.json)

## Запуск

Приложение можно скомпилировать и запустить, используя стандартную процедуру сборщика Maven.