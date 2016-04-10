# team16_week4

This is project of team 16 of 'Actual Coding' class

It covers 'Bill System'


#<< Program Detail >>


<h1>Build Program</h1>

Clone this repository and

	cd build
	java -jar team16_bill_system.jar
	
<h1>Input</h1>

Program is made on infinity loop. Program works with 2 menu
* 1 : Calculate Total cost of last month
* 2 : Exit program

if 1st menu chosen, input should be made of a sequence with
* Plan Type - Gold or Silver
* Usage of time
* Usage of lines

ex) Gold 900 1 / Silver 2415 4 / Gold 1123 3

<h1>Output</h1>

* Plan Type, Usage of time, Usage of lines
* Basic rate + Additional time cost + Additional line cost = Total Cost


<h1>Detailed</h1>
이 프로그램은 유저의 정보에 기반하여 이전 달의 지불금액을 출력해줍니다.

Bill Class는 유저의 정보를 토대로 금액을 계산하며 이 정보들은 User, Plan, DetailedCost, PrintExpectedBill 객체를 통해 얻어집니다. Plan은 Account들의 Plan중, 어느 Plan인지에 대한 정보를 가지고 있으며, User는 사용한 데이터에 대한 정보를 가지고 있습니다. 이 정보들을 DetailedCost에 넘겨주면 다음과 같은 규칙에 의해 최종 결과 값을 계산합니다.

	Type - Gold
	기본 요금 : 49.95 | 기본 사용 시간 : 1000 | 초과 사용 시간 요금 : 0.45 | 추가 회선 요금 : 14.50
	
	Type - Silver
	기본 요금 : 29.95 | 기본 사용 시간 : 500 | 초과 사용 시간 요금 : 0.54 | 추가 회선 요금 : 21.50
	
	공통
	추가 회선이 3개 이상일 때 부터는 3번째 회선부터 5.00의 추가 요금만 지불한다.
	
DetailedCost가 정보를 토대로 전체 요금을 계산하면 PrintExpectedBill이 이 결과 값을 토대로 형식에 맞추어 String Data를 가공합니다. 그리고 이렇게 가공된 데이터는 AppController를 통해서 log에 기록되고 출력의 형식은 AppController에서 확인해 볼 수 있습니다.
