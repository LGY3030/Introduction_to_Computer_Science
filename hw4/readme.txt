系級：資訊108
學號：F14046012
姓名：林冠宇 
修課班別：計算機概論(電機乙)

程式檔案名稱：1. hw4.java  2. player.java  3. windCard.java  4. waterCard.java  5. thunderCard.java  6. solidCard.java  
	      7. fireCard.java  8. A1.java  9. A2.java  10. B1.java  11. B2.java  12. C1.java  13. C2.java  14. D1.java
	      15. D2.java  16. E1.java


使用說明：
1.javac hw4.java (編譯)
2.java hw4 (執行)

程式剛開始執行要先輸入雙方玩家姓名 [player1_name][player2_name] (ex: Mike John) ，接著由玩家一先開始

玩家一(roundflag==1):
1.輸入select [卡片編號] [卡片位置] [卡片狀態] (ex:select A1 U1 attack)，可以出牌(選擇卡片及狀態)
2.輸入[攻擊的卡片位置] attack [被攻擊的卡片位置] (ex:U1 attack D1)，可以選擇想要攻擊的卡片以及被攻擊的卡片進行對戰
3.輸入[攻擊的卡片位置] attack enemy (ex:U1 attack enemy)，可以選擇想要攻擊的卡片去攻擊的玩家
4.輸入change [想切換狀態的卡片位置] (ex:change U1)，可以選擇想要切換狀態的卡片位置
5.輸入finish，結束當前玩家之回合
6.輸入exit，可以結束系統

玩家二(roundflag==2):
1.輸入select [卡片編號] [卡片位置] [卡片狀態] (ex:select A1 U1 attack)，可以出牌(選擇卡片及狀態)
2.輸入[攻擊的卡片位置] attack [被攻擊的卡片位置] (ex:U1 attack D1)，可以選擇想要攻擊的卡片以及被攻擊的卡片進行對戰
3.輸入[攻擊的卡片位置] attack enemy (ex:U1 attack enemy)，可以選擇想要攻擊的卡片去攻擊的玩家
4.輸入change [想切換狀態的卡片位置] (ex:change U1)，可以選擇想要切換狀態的卡片位置
5.輸入finish，結束當前玩家之回合
6.輸入exit，可以結束系統