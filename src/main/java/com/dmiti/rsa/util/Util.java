package com.dmiti.rsa.util;

import java.math.BigInteger;

public class Util {
    public static final char[] characters = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'а', 'б', 'в', 'г',
            'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч',
            'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л',
            'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', ' ',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+',
            ',', '-', '.', '/', ':', ';', '<', '>', '?', '@', '[', '\\', ']', '^', '_', '`', '~', '№', '=', '|', '/',
            '{', '}'};

    public static final String[] words = new String[] {"год", "дело", "день", "рука", "лицо", "глаз", "друг", "дом",
            "вид", "час", "отец", "нога", "вода", "бог", "жена", "ночь", "суд", "стол", "имя", "путь", "душа", "язык",
            "цель", "муж", "роль", "мама", "мера", "труд", "тело", "утро", "мать", "сын", "век", "идея", "окно",
            "ряд", "счёт", "цена", "план", "вещь", "срок", "член", "ход", "опыт", "лес", "тип", "брат", "шаг", "игра",
            "край", "банк", "зал", "врач", "небо", "факт", "союз", "род", "дух", "поле", "угол", "двор", "база",
            "стих", "ум", "море", "удар", "сон", "поэт", "пара", "дочь", "фонд", "папа", "курс", "губа", "река",
            "нос", "ухо", "сад", "лето", "итог", "рис", "рот", "цвет", "лист", "гора", "воля", "зона", "бой", "метр",
            "снег", "акт", "этап", "доля", "учёт", "враг", "го", "клуб", "зуб", "сеть", "семь", "боль", "кожа",
            "знак", "газ", "звук", "зима", "хлеб", "суть", "дума", "долг", "дед", "этаж", "дядя", "храм", "чудо",
            "ужас", "тень", "рыба", "дама", "июнь", "баба", "мозг", "шея", "беда", "фон", "дача", "стул",
            "июль", "спор", "вино", "ключ", "царь", "вкус", "лоб", "слой", "слух", "бок", "быль", "очко", "грех",
            "мясо", "урок", "крик", "ящик", "вес", "дно", "тон", "щека", "нож", "кадр", "мост", "вход", "шум",
            "обед", "смех", "сбор", "риск", "пиво", "штаб", "брак", "штат", "куст", "шанс", "кофе", "дым", "лёд",
            "конь", "вина", "миг", "тётя", "полк", "село", "танк", "еда", "мэр", "темп", "уход", "мина", "act", "add",
            "age", "aged", "aim", "air", "apt", "area", "arm", "army", "art", "ask", "baby", "back", "bad", "bald",
            "bank", "bare", "base", "be", "bear", "beat", "bed", "big", "blue", "body", "bold", "book", "born", "boy",
            "busy", "buy", "call", "calm", "car", "care", "cat", "cd", "city", "club", "cold", "come", "cool", "cost",
            "cosy", "cry", "cut", "daft", "damp", "data", "date", "day", "dead", "deaf", "deal", "dear", "deep",
            "deny", "die", "dim", "dire", "do", "dog", "door", "draw", "drop", "drug", "dry", "dull", "dumb", "duty",
            "dvd", "easy", "eat", "end", "eye", "face", "fail", "fair", "fall", "far", "fast", "fat", "feed", "feel",
            "fill", "film", "find", "fine", "fire", "firm", "fit", "five", "flat", "flu", "fly", "fond", "foot",
            "form", "foul", "four", "free", "full", "fund", "gain", "game", "gay", "get", "girl", "give", "glad",
            "go", "gold", "good", "grey", "grim", "grow", "hair", "hall", "hand", "hang", "hard", "hate", "have",
            "head", "hear", "help", "hide", "high", "hit", "hold", "holy", "home", "hope", "hot", "hour", "huge",
            "idea", "ill", "job", "join", "just", "keen", "keep", "kill", "kind", "king", "know", "lady", "lamp",
            "land", "late", "law", "lay", "lazy", "lead", "lean", "left", "leg", "let", "lie", "life", "lift", "like",
            "line", "link", "live", "long", "look", "lord", "lose", "loud", "love", "low", "lush", "mad", "make",
            "man", "mark", "mean", "meet", "mere", "mid", "mild", "mile", "mind", "miss", "move", "name", "near",
            "neat", "need", "new", "nice", "nine", "nose", "note", "old", "one", "open", "oval", "own", "page",
            "pain", "pale", "park", "pass", "pay", "pen", "pick", "pill", "pink", "plan", "play", "poor", "posh",
            "pull", "pure", "push", "put", "rain", "rare", "rate", "raw", "read", "real", "rear", "red", "rest",
            "rich", "ring", "ripe", "rise", "road", "role", "roof", "room", "rude", "rule", "run", "sad", "safe",
            "save", "say", "sea", "see", "seek", "seem", "sell", "send", "set", "sexy", "shoe", "show", "shy",
            "sick", "side", "sign", "sing", "sit", "six", "sky", "slim", "slow", "sofa", "soft", "sole", "son",
            "sore", "stay", "stop", "sun", "sure", "take", "talk", "tall", "taut", "tax", "team", "tell", "ten",
            "tend", "term", "test", "that", "thin", "tidy", "time", "tiny", "town", "tree", "true", "try", "turn",
            "tv", "two", "type", "ugly", "unit", "use", "vain", "vary", "vast", "void", "wait", "walk", "wall",
            "want", "war", "warm", "warn", "wary", "way", "weak", "wear", "week", "well", "wet", "wide", "wife",
            "wild", "win", "wise", "wish", "word", "work", "work", "wry", "year", "zero"
    };

    public static BigInteger pow(BigInteger base,BigInteger exponent) {
        BigInteger result = BigInteger.ONE;
        while (exponent.compareTo(BigInteger.ZERO) != 0) {
            result = result.multiply(base);
            exponent = exponent.subtract(BigInteger.ONE);
        }

        return result;
    }
}
