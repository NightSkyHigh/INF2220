class SimilarWords{
  private String word;
  final private char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

  private String[] similar;
  private int insert = 0;

  public SimilarWords(String word){
    this.word = word;
    similar = new String[wordNum()];
    wrongOrder();
    replaceOneLetter();
    frontEndSimilarity();
    OneTooMuch();
  }

  private int wordNum(){
    int charNum = word.length();
    int aSize = alphabet.length;

    int i = 0;
    i += charNum - 1;
    i += charNum * aSize;
    i += (1 + charNum) * aSize;
    i+= charNum;
    return i + 1;
  }

  public void wrongOrder() {
  for (int i = 0; i < word.length() - 1; i++) {
    similar[insert++] = swap(i, i+1, word.toCharArray());
  }
}

private String swap(int a, int b, char[] word) {
  char tmp = word[a];
  word[a] = word[b];
  word[b] = tmp;
  return new String(word);
}

public void replaceOneLetter() {
  for (int i = 0; i < word.length(); i++) {
    for (int j = 0; j < alphabet.length; j++) {
      char[] newWord = word.toCharArray();
      newWord[i] = alphabet[j];

      similar[insert++] = new String(newWord);
    }
  }
}

public void frontEndSimilarity() {
  char[] newWord = new char[word.length()+1];
  char[] orgWord = word.toCharArray();

  for (int newLetter = 0; newLetter < alphabet.length; newLetter++) {
    for (int i = 0; i < newWord.length; i++) {
      for (int j = 0, k = 0; j < newWord.length; j++) {
        if (j == i) {
          // fills the open space with a letter from alphabet
          newWord[j] = alphabet[newLetter];
        } else {
          newWord[j] = orgWord[k++];
        }
      }
      similar[insert++] = new String(newWord);
    }
  }
}

public void OneTooMuch() {
  char[] newWord = new char[word.length()-1];
  char[] orgWord = word.toCharArray();

  for (int i = 0; i < word.length(); i++) {
    for (int j = 0, k = 0; j < newWord.length; j++, k++) {
      if (k == i) k++;
      newWord[j] = orgWord[k];
      }
    similar[insert++] = new String(newWord);
    }
  }

  public String[] similarList(){
    return similar;
  }
}
