package controlselection.accents;

public class WithoutAccents {

    public char withoutAccents(char isAccent) {
        char resultChar;
        switch (isAccent) {
            case 'á':
                resultChar = 'a';
                break;
            case 'é':
                resultChar = 'e';
                break;
            case 'í':
                resultChar = 'i';
                break;
            case 'ó':
            case 'ö':
            case 'ő':
                resultChar = 'o';
                break;
            case 'ú':
            case 'ü':
            case 'ű':
                resultChar = 'u';
                break;
            case 'Á':
                resultChar = 'A';
                break;
            case 'É':
                resultChar = 'E';
                break;
            case 'Í':
                resultChar = 'I';
                break;
            case 'Ó':
            case 'Ö':
            case 'Ő':
                resultChar = 'O';
                break;
            case 'Ú':
            case 'Ü':
            case 'Ű':
                resultChar = 'U';
                break;
            default:
                resultChar = isAccent;
        }
        return resultChar;
    }
}
