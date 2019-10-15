# Dates
Dates Calculator

 ## Steps to Add in your Project
  
 ### Step 1 : ADD Dependency
    dependencies {
        implementation 'com.github.shivanshshrotriya:Date:v1.0'
      }

     allprojects {
	    repositories {
		  ...
	  	maven { url 'https://jitpack.io' }
	      }
      }
      
### Step 2 : Import in Java File
    
    import com.timepasstechnologies.date.DateCalculator;
    
    
### Step 3 : Make Object of DateCalculator

     DateCalculator datecalculator = new DateCalculator();
     
*or directly access function*
                      
     int hour = new DataCalculator().getHour(String DateTime);                 
     
### Step 4 : Add Functions
- getDaysInMonth(int month, int year)   [ returns String ]
- getTimeBetweenDates(String start_at, String end_at)  [ returns String ]
- addTime( String Duration_1, String Duration_2)  [ returns String ]
- subtractTime(String Duration_1, String Duration_2)  [ returns String ]
- getYear( String DateTime) [ returns int ]
- getMonth(String DateTime) [ returns int ]
- getDay(String DateTime) [ returns int ]
- getHour(String DateTime) [ returns int ]
- getMinutes(String DateTime) [ returns int ]
- getSeconds(String DateTime) [ returns int ]

### For Example
[Go Here](https://github.com/shivanshshrotriya/Dates/blob/master/app/src/main/java/com/timepasstechnologies/dates/MainActivity.java).
