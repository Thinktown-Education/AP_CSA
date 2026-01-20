# Unit 3.2 — Impact of Program Design

## Learning Goals
By the end of this unit, you will:
- Understand system reliability and how to test programs thoroughly
- Recognize beneficial and harmful impacts of programs on society
- Understand intellectual property and licensing concerns in programming

## 1. System Reliability

**System reliability** is the ability of a program to perform correctly without failure.

### 1.1 Why Reliability Matters

Unreliable programs cause:
- Financial loss (incorrect transactions, system downtime)
- Safety issues (medical devices, transportation systems)
- Loss of user trust
- Legal consequences

### 1.2 Testing for Reliability

Test programs with a **variety of conditions**:

| Condition Type | Example |
|---|---|
| Normal | Expected input (typical grades 70-95) |
| Boundary | Extremes (0, 100) |
| Edge cases | Unusual situations (one item, empty list) |
| Invalid | Bad data (negative numbers) |
| Large data | High volume (1,000,000 records) |
| Empty/null | Missing data |

**Example:** A grade calculator tested only with grades 70-90 will fail when given 0 or 100.

### 1.3 Real Impact

Knight Capital's trading software had an old algorithm left in the code. Deployed without testing under real conditions, it made erroneous trades in 45 minutes and lost **$440 million**—destroying the company.

## 2. Impact on Society

Programs have profound effects on society—both beneficial and harmful.

### 2.1 Beneficial Impacts
- Healthcare: diagnostic tools, telemedicine, research
- Education: online learning, accessibility
- Environment: monitoring, energy management
- Economy: e-commerce, productivity
- Connection: video calls, translation, accessibility

### 2.2 Harmful Impacts
- Privacy invasion through tracking and data collection
- Misinformation spread via algorithms
- Discrimination in hiring, loans, policing
- Job displacement through automation
- Mental health issues (addiction, comparison, cyberbullying)
- Environmental damage (data centers, e-waste)

### 2.3 Unintended Consequences

Programs often have effects beyond their original purpose:

**Facial Recognition:** Designed to help identify crime suspects, but enables mass surveillance and has higher error rates for people of color—leading to wrongful arrests.

**Social Media Algorithms:** Designed to show engaging content, but recommend increasingly extreme material, leading to radicalization and mental health decline.

### 2.4 Programmer Responsibility

Ask yourself:
1. Who benefits from this program?
2. Who could be harmed?
3. What unintended consequences might occur?
4. How could this be misused?
5. What safeguards should I include?
6. Is this ethical?

## 3. Legal Issues and Intellectual Property

**Intellectual property (IP)** is ownership of creative work, including code.

### 3.1 Open Source vs. Proprietary

**Open Source:** Free to use under a license
- MIT License: Very permissive (just give credit)
- Apache License: Requires attribution
- GPL: Free but modifications must be shared
- Examples: Linux, Python, Apache, Android

**Proprietary:** Owned by company/individual
- Must purchase license
- Strict terms of use
- Cannot share or modify
- Examples: Windows, Photoshop, Oracle

### 3.2 Copyright Automatically Protects Your Code

When you write code:
- You own the copyright automatically
- Others cannot use it without permission
- You must grant permission through a license to let others use it

### 3.3 Common IP Mistakes

| Mistake | Consequence |
|---|---|
| Use code without checking license | Legal action, fines |
| Copy code from tutorial without attribution | Violate copyright |
| Use proprietary code without paying | Copyright infringement |
| Claim credit for others' code | Plagiarism, legal issues |

### 3.4 Real-World Dispute

**Oracle vs. Google (2010-2021):** Google used Java APIs in Android. Oracle sued for copyright infringement. The case lasted 11 years and cost millions—showing how uncertain IP law can be.

### 3.5 Best Practices

1. Know your sources and track where code comes from
2. Check and understand the license
3. Follow license requirements exactly
4. Give proper attribution
5. Prefer open source when possible (free, well-tested)
6. Choose appropriate license for your own code
