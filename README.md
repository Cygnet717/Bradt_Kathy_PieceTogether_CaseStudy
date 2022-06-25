# Capstone Project: Piece Together

Created By Kathy Bradt

## Overview

This is an app for those who want to remember things that matter.
- When did I take the vacation to Ireland?
- What is the name of the person I bought my boat from?
- How much did Thomas weigh when he was born?
- What was my manager's name for the job I had 7 years ago?
  
Whether you are just reminiscing or applying to a new job that asks for 7 years of work history, have all your important life events stored in one location for future reference.


## User Stories

As a User I want to:  
- Make a new account **so that** I can use the site
- Log into my account **so that** I can access my events
- View all my events sorted by Year **so that** I can easily navigate through my events
- View only events of a particular type  **so that** all events of the same type at once
- Add new events to my account **so that** I can keep track of important life events
- Edit events in my account **so that** I can correct/change the information
- View my user data **so that** I can confirm the information is correct
- Edit my user data **so that** I can change my name or email address

## Models and Database:

![Models](/src/main/resources/static/images/models.png)

![ERD](/src/main/resources/static/images/ERD.png)

Originally started with 8 model of events then quickly realized that many of them contained the same data. To me more efficient many of them were condensed into the other model with just the addition of an eventType column.

- Test each custom query created in each repository
- Test at least one method in each of the service classes
- Include at least one parameterized test
- Include at least one test suite
- Include a schema diagram of the tables
- Use JUnit to perform unit tests on the JPA repositories/services

## Technical Challenges

My main exciting challenges with this project stemmed from learning new technologies.  To overcome these obstacles I did a lot of reading documentation, consulting stackoverflow and classmates. 

# Future

- Include Admin role and access to usage information
- Mobile app
- Include video and picture upload
- Make it social: add friends, share events, make events public/private
- Allow user to create new event type
- 