First Part: Creating a test plan for one of mobile applications. (Yallkora)
=================
Impact level 1 is highest and 3 is lowest
1. User should able to see fixtures (past,current and future) in main panel (impact level 1)
2. User should be able to see , important news and recent news in main panel (impact level 1)
3. User can view more new news in news panel and can classify as latest football news and other sports. (impact level 1)
4. User should be able to view matches (currently played and finshed) in fixtures (matches) panel. (impact level 2)
5. User should able to manage his favourite team(s) and select multiple teams from same league/different leagues in team panel (impact level 2)
6. User should able to manage see favourite team standings in tournaments and news (impact level 2)
7. User should be able to see different tournaments along ranking for leagues (playoff chart for cups), games, statistics and news in tournament panel (impact level 2)
8. User can view summary, formation , minute by minute summary during and after match(impact level 2)
9. User can get team results and news by simply clicking on it (impact level 2)
10. User gets push notifications for top news (impact level 3)

Second Part: Reporting defects for the Yallakora
=====================
All are tested on ipad mini and Samsung a70
 
#### Defect#1 Under news panel, football news appearing under other sports news tab

<ul>
	<li>Linked to testcase#3</li>
	<li>Step to reproduce</li>
	<ol>
	<li>Click on news from bar</li>
	<li>Click on either latest news tab sports</li>
	</ol>
	<li>Expected: The section should (have only) highlight news for sports other than football</li>
	<li>Actual: The section has football news as highlighted in the screenshot.</li>
	<li>Severity: Moderate</li>
	<li>Priority: Moderate</li>
</ul>




#### Defect#2 User is unable to go to premier league except after click on drop down for championships with the first value Uefa championship 
<ul>
	<li>Linked to testcase#5</li>
click</li>
	<li>Step to reproduce</li>
	<ol>
	<li>Go to your team panel</li>
	<li>Click on you favourite team for example Manchester city</li>
	<li>Only when you click on Uefa championship then you will find the premier league</li>
	</ol>
	<li>Expected: A label next to the drop down should exist with the value choose league</li>
	<li>Actual: A drop down looks like a button where the user to clicks to go to premier league.</li>
	<li>Severity: Moderate</li>
	<li>Priority: Moderate</li>
	<li> More info:	After selecting your favourite team, the dropdown looks like a button and sometimes the top value in dropdown is empty and will not show competitions except after clicking on it </li>
</ul>
    

#### Defect#3 Ui issues, the days in matches panel is shifted
<ul>
<li>Linked to testcase#1</li>
	<li>Step to reproduce</li>
	<ol>
	<li>Go to matches panel</li>
	<li>Rotate the screen.</li>
	</ol>
	<li>Expected: a match</li>
	<li>Actual: The days are on the left.</li>
	<li>Severity: low</li>
	<li>Priority: low</li></ul>
</ul>
#### Defect#4 Under news panel, Other sports news appearing under football news tab.
<ul>
	<li>Linked to testcase#3</li>
	<li>Step to reproduce</li>
	<ol>
	<li>Click on news from bar</li>
	<li>Click on either latest other news sports</li>
	</ol>
	<li>Expected: The section should have only football news</li>
	<li>Actual: The section has other sports as highlighted in the screenshot.</li>
	<li>Severity: Moderate</li>
	<li>Priority: Moderate</li>
</ul>


#### Defect#5 Playoff chart should appear for cups in the tournament schedule
<ul>
	<li>Linked to testcase#7</li>
	<li>Step to reproduce</li>
	<ol>
	<li>Click on tournament tabs</li>
	<li>Click on any cup competition such as English cup</li>
	</ol>
	<li>Expected: The section should show the playoff chart</li>
	<li>Actual: The page is empty.</li>
	<li>Severity: Moderate</li>
	<li>Priority: low</li>
</ul>

#### Defect#6 No back button when choosing the league for the favorite team
<ul>
	<li>Linked to testcase#6</li>
	<li>Step to reproduce</li>
	<ol>
	<li>Click on your team tab</li>
	<li>Click on add button</li>
	</ol>
	<li>Expected: back button should be appearing</li>
	<li>Actual: There is no back button, you have to select a team then go back.</li>
	<li>Severity: Moderate</li>
	<li>Priority: Moderate</li>
</ul>

#### Defect#7 Panel for Minute by minute report for match after clicking on minute by minute button is empty
<ul>
	<li>Linked to testcase#8</li>
	<li>Step to reproduce</li>
	<ol>
	<li>Go to matches panel</li>
	<li>Select a match</li>
	<li>Click minute by minute button</li>
	</ol>
	<li>Expected: report of the match or if not played it should state that the match was not played</li>
	<li>Actual: Empty</li>
	<li>Severity: Moderate</li>
	<li>Priority: Moderate</li>
</ul>



Screenshots for defects:
======================
#### Defect#1 (Most of the news on the page are football)

![image](https://user-images.githubusercontent.com/32613878/116468617-5f629880-a871-11eb-8ce2-c0c19c685ebd.png)

 #### Defect#2
 ![image](https://user-images.githubusercontent.com/32613878/116471527-13b1ee00-a875-11eb-8196-1994caa9533a.png)
\
![image](https://user-images.githubusercontent.com/32613878/116471228-b74ece80-a874-11eb-9090-ee4179f14bcf.png)
\
How to select another competation:\
![image](https://user-images.githubusercontent.com/32613878/116471795-64294b80-a875-11eb-8ebf-56de1ecf5f3c.png)


#### Defect#3
![image](https://user-images.githubusercontent.com/32613878/116469562-99806a00-a872-11eb-9e03-ae82dae642ff.png)
\
![image](https://user-images.githubusercontent.com/32613878/116470427-b5d0d680-a873-11eb-91aa-871caa27013b.png)

#### Defect#4 (Third news piece is handball)
![image](https://user-images.githubusercontent.com/32613878/116472198-df8afd00-a875-11eb-9a76-924b603ee128.png)

#### Defect#5
![image](https://user-images.githubusercontent.com/32613878/116472351-195c0380-a876-11eb-93af-f447a5d41b2f.png)

#### Defect#6
![image](https://user-images.githubusercontent.com/32613878/116472578-5a541800-a876-11eb-8a5b-093eb6da558a.png)
#### Defect#7
![image](https://user-images.githubusercontent.com/32613878/116474425-c59ee980-a878-11eb-9d98-3807ee0e98a4.png)
