
# Daily Trade Reporting Engine

A simple daily trade reporting engine. It generate a report that shows.

 	Amount in USD settled incoming everyday
	Amount in USD settled outgoing everyday
	Ranking of entities based on incoming and outgoing amount. Eg: If entity foo instructs the highest amount for a buy 	instruction, then foo is rank 1 for outgoing  


## Reporting 
The ReportGenerator class is responsible of generating reports. Execute Main class to generate daily trade report.
Report get printed on console

## Engine rules
   1. A work week starts Monday and ends Friday, unless the currency of the trade is AED or SAR.
   2. No other holidays to be taken into account.
   3. A trade can only be settled on a working day.
   4. If an instructed settlement date falls on a weekend, then the settlement date should be changed 	to the next working day.
   5.USD amount of a trade = Price per unit * Units * Agreed Fx


