Set<String> wordDict = new HashSet<>();
wordDict.add("leet");
wordDict.add("code");

System.out.println(wordBreak("leetcode", wordDict, 0)); // Expected output: true

wordDict.add("apple");
wordDict.add("pen");

System.out.println(wordBreak("applepenapple", wordDict, 0)); // Expected output: true

wordDict.add("cats");
wordDict.add("dog");

System.out.println(wordBreak("catsandog", wordDict, 0)); // Expected output: false