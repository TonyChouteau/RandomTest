import random as r
import math as m

def rand(n, ite):
	results = [0]*n
	
	for _ in range(ite):
		rand = m.floor(r.random()*n)
		results[rand] += 1

	return results

def getDif(results, mean):
	dif = [0]*len(results)

	for i in range(len(results)):
		dif[i] = results[i]-mean
	
	return dif

def oneTest():
	numbers = 10
	iterations = 10000000

	results = rand(numbers, iterations)
	print(results)

	mean = iterations/numbers
	dif = getDif(results, mean)
	print(dif)

def multipleTest(total):
	numbers = 10
	iterations = 10000000

	values = []

	for i in range(total):
		print(i)
		results = rand(numbers, iterations)
		
		mean = iterations/numbers
		dif = getDif(results, mean)
		for j in range(len(dif)):
			dif[j] = abs(dif[j])

		values.append(max(dif))
	
	return values

maxList = multipleTest(10)
print(maxList)