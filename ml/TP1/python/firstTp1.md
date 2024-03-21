# This is the first tp1 

# exo 1 :

so here we have step 1

*Importation des bibliothèques*

step 2

*Importer le jeu de données*

step 3

*Diviser l'ensemble de données en ensemble d'apprentissage et en ensemble
de test*

step 4 

*Entraîner le modèle de régression linéaire simple sur l'ensemble
d'entraînement*

step 5

*Prédire les résultats de l'ensemble de tests*

step 6 

*Comparaison de l'ensemble de test avec les valeurs prédites*



```python
 #STEP 1
    
import numpy as np
import pandas as pd # storage the dataset 
import matplotlib.pyplot as plt # plotting the dataset

 #STEP 2
    
dataset = pd.read_csv('Salary_Data.csv')
dataset.head()
X = dataset.iloc[:, :-1].values # e choose all the rows and colums except the last column 
y = dataset.iloc[:,-1].values # all rows and the last column
# choosen the firt 5 from the data set
dataset.head(5)   

 #STEP 3
    
from sklearn.model_selection import train_test_split  
X_train, X_test, y_train, y_test = train_test_split(X,y,test_size=0.2)
  
 #STEP 4
 
 
from sklearn.linear_model import LinearRegression
regressor = LinearRegression()
regressor.fit(X_train,y_train) 
 
 #STEP 5 
 
# predect the y hat 
y_pred = regressor.predict(X_test) 

 #STEP 6

#comparaison between the real values and the values of the hypothes
df=pd.DataFrame({'Real Values':y_test,'Predicted Values':y_pred})
df

```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>Real Values</th>
      <th>Predicted Values</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>39891.0</td>
      <td>46591.208423</td>
    </tr>
    <tr>
      <th>1</th>
      <td>116969.0</td>
      <td>116212.523200</td>
    </tr>
    <tr>
      <th>2</th>
      <td>112635.0</td>
      <td>117166.239841</td>
    </tr>
    <tr>
      <th>3</th>
      <td>61111.0</td>
      <td>68526.691161</td>
    </tr>
    <tr>
      <th>4</th>
      <td>91738.0</td>
      <td>90462.173899</td>
    </tr>
    <tr>
      <th>5</th>
      <td>46205.0</td>
      <td>38007.758656</td>
    </tr>
  </tbody>
</table>
</div>



# step 7 : Visualiser les résultats


```python
plt.scatter(X_test, y_test, color = 'red')
plt.scatter(X_test, y_pred, color = 'green')
plt.plot(X_train, regressor.predict(X_train), color = 'black')
plt.title('Salary vs Experience (Result)')
plt.xlabel('YearsExperience')
plt.ylabel('Salary')
plt.show()
```


    
![png](output_3_0.png)
    


# exo 2 :



```python
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

dataset = pd.read_csv('50_Startups.csv')
dataset.head(5) # Nous imprimons le DataFrame

```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>R&amp;D Spend</th>
      <th>Administration</th>
      <th>Marketing Spend</th>
      <th>State</th>
      <th>Profit</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>165349.20</td>
      <td>136897.80</td>
      <td>471784.10</td>
      <td>New York</td>
      <td>192261.83</td>
    </tr>
    <tr>
      <th>1</th>
      <td>162597.70</td>
      <td>151377.59</td>
      <td>443898.53</td>
      <td>California</td>
      <td>191792.06</td>
    </tr>
    <tr>
      <th>2</th>
      <td>153441.51</td>
      <td>101145.55</td>
      <td>407934.54</td>
      <td>Florida</td>
      <td>191050.39</td>
    </tr>
    <tr>
      <th>3</th>
      <td>144372.41</td>
      <td>118671.85</td>
      <td>383199.62</td>
      <td>New York</td>
      <td>182901.99</td>
    </tr>
    <tr>
      <th>4</th>
      <td>142107.34</td>
      <td>91391.77</td>
      <td>366168.42</td>
      <td>Florida</td>
      <td>166187.94</td>
    </tr>
  </tbody>
</table>
</div>




```python

X = dataset.iloc[:, :-1].values # all the rows and without the last colum is "y " 
y = dataset.iloc[:, -1].values # all the rows with the last colums is "y"
# la bib sklearn encodons ces données catégorielles
from sklearn.compose import ColumnTransformer #colonne du DataFrame d'être transformée séparément.
from sklearn.preprocessing import OneHotEncoder #transformer notre colonne"State" (index=3) en données numériques.
ct = ColumnTransformer(transformers =[('encoder', OneHotEncoder(), [3])],

remainder = 'passthrough')

X = np.array(ct.fit_transform(X))
X

```




    array([[0.0, 0.0, 1.0, 165349.2, 136897.8, 471784.1],
           [1.0, 0.0, 0.0, 162597.7, 151377.59, 443898.53],
           [0.0, 1.0, 0.0, 153441.51, 101145.55, 407934.54],
           [0.0, 0.0, 1.0, 144372.41, 118671.85, 383199.62],
           [0.0, 1.0, 0.0, 142107.34, 91391.77, 366168.42],
           [0.0, 0.0, 1.0, 131876.9, 99814.71, 362861.36],
           [1.0, 0.0, 0.0, 134615.46, 147198.87, 127716.82],
           [0.0, 1.0, 0.0, 130298.13, 145530.06, 323876.68],
           [0.0, 0.0, 1.0, 120542.52, 148718.95, 311613.29],
           [1.0, 0.0, 0.0, 123334.88, 108679.17, 304981.62],
           [0.0, 1.0, 0.0, 101913.08, 110594.11, 229160.95],
           [1.0, 0.0, 0.0, 100671.96, 91790.61, 249744.55],
           [0.0, 1.0, 0.0, 93863.75, 127320.38, 249839.44],
           [1.0, 0.0, 0.0, 91992.39, 135495.07, 252664.93],
           [0.0, 1.0, 0.0, 119943.24, 156547.42, 256512.92],
           [0.0, 0.0, 1.0, 114523.61, 122616.84, 261776.23],
           [1.0, 0.0, 0.0, 78013.11, 121597.55, 264346.06],
           [0.0, 0.0, 1.0, 94657.16, 145077.58, 282574.31],
           [0.0, 1.0, 0.0, 91749.16, 114175.79, 294919.57],
           [0.0, 0.0, 1.0, 86419.7, 153514.11, 0.0],
           [1.0, 0.0, 0.0, 76253.86, 113867.3, 298664.47],
           [0.0, 0.0, 1.0, 78389.47, 153773.43, 299737.29],
           [0.0, 1.0, 0.0, 73994.56, 122782.75, 303319.26],
           [0.0, 1.0, 0.0, 67532.53, 105751.03, 304768.73],
           [0.0, 0.0, 1.0, 77044.01, 99281.34, 140574.81],
           [1.0, 0.0, 0.0, 64664.71, 139553.16, 137962.62],
           [0.0, 1.0, 0.0, 75328.87, 144135.98, 134050.07],
           [0.0, 0.0, 1.0, 72107.6, 127864.55, 353183.81],
           [0.0, 1.0, 0.0, 66051.52, 182645.56, 118148.2],
           [0.0, 0.0, 1.0, 65605.48, 153032.06, 107138.38],
           [0.0, 1.0, 0.0, 61994.48, 115641.28, 91131.24],
           [0.0, 0.0, 1.0, 61136.38, 152701.92, 88218.23],
           [1.0, 0.0, 0.0, 63408.86, 129219.61, 46085.25],
           [0.0, 1.0, 0.0, 55493.95, 103057.49, 214634.81],
           [1.0, 0.0, 0.0, 46426.07, 157693.92, 210797.67],
           [0.0, 0.0, 1.0, 46014.02, 85047.44, 205517.64],
           [0.0, 1.0, 0.0, 28663.76, 127056.21, 201126.82],
           [1.0, 0.0, 0.0, 44069.95, 51283.14, 197029.42],
           [0.0, 0.0, 1.0, 20229.59, 65947.93, 185265.1],
           [1.0, 0.0, 0.0, 38558.51, 82982.09, 174999.3],
           [1.0, 0.0, 0.0, 28754.33, 118546.05, 172795.67],
           [0.0, 1.0, 0.0, 27892.92, 84710.77, 164470.71],
           [1.0, 0.0, 0.0, 23640.93, 96189.63, 148001.11],
           [0.0, 0.0, 1.0, 15505.73, 127382.3, 35534.17],
           [1.0, 0.0, 0.0, 22177.74, 154806.14, 28334.72],
           [0.0, 0.0, 1.0, 1000.23, 124153.04, 1903.93],
           [0.0, 1.0, 0.0, 1315.46, 115816.21, 297114.46],
           [1.0, 0.0, 0.0, 0.0, 135426.92, 0.0],
           [0.0, 0.0, 1.0, 542.05, 51743.15, 0.0],
           [1.0, 0.0, 0.0, 0.0, 116983.8, 45173.06]], dtype=object)



# Étape 4 :
Diviser l'ensemble de données en ensemble d'apprentissage et en ensemble
de test


```python
from sklearn.model_selection import train_test_split # two parts 10 for the testing and 40 for the learning 
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size = 0.2)
from sklearn.linear_model import LinearRegression
regressor = LinearRegression()
regressor.fit(X_train, y_train) # reg.fit pour ajuster l'ensemble de données d'entraînement
y_pred = regressor.predict(X_test) # y_hat 

```

# Étape 7 : 
Comparaison de l'ensemble de test avec les valeurs prédites


```python
df = pd.DataFrame({'Real Values':y_test, 'Predicted Values':y_pred})
df
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>Real Values</th>
      <th>Predicted Values</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>146121.95</td>
      <td>135680.991429</td>
    </tr>
    <tr>
      <th>1</th>
      <td>96479.51</td>
      <td>88634.500283</td>
    </tr>
    <tr>
      <th>2</th>
      <td>108552.04</td>
      <td>112151.380979</td>
    </tr>
    <tr>
      <th>3</th>
      <td>97483.56</td>
      <td>96689.494677</td>
    </tr>
    <tr>
      <th>4</th>
      <td>134307.35</td>
      <td>127505.875626</td>
    </tr>
    <tr>
      <th>5</th>
      <td>69758.98</td>
      <td>58217.466005</td>
    </tr>
    <tr>
      <th>6</th>
      <td>90708.19</td>
      <td>74392.674276</td>
    </tr>
    <tr>
      <th>7</th>
      <td>132602.65</td>
      <td>150399.681188</td>
    </tr>
    <tr>
      <th>8</th>
      <td>65200.33</td>
      <td>63730.977336</td>
    </tr>
    <tr>
      <th>9</th>
      <td>49490.75</td>
      <td>54680.318758</td>
    </tr>
  </tbody>
</table>
</div>



# exo 3 :



```python
import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
dataset = pd.read_csv('Position_Salaries.csv')
dataset.head(5)
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>Position</th>
      <th>Level</th>
      <th>Salary</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>Business Analyst</td>
      <td>1</td>
      <td>45000</td>
    </tr>
    <tr>
      <th>1</th>
      <td>Junior Consultant</td>
      <td>2</td>
      <td>50000</td>
    </tr>
    <tr>
      <th>2</th>
      <td>Senior Consultant</td>
      <td>3</td>
      <td>60000</td>
    </tr>
    <tr>
      <th>3</th>
      <td>Manager</td>
      <td>4</td>
      <td>80000</td>
    </tr>
    <tr>
      <th>4</th>
      <td>Country Manager</td>
      <td>5</td>
      <td>110000</td>
    </tr>
  </tbody>
</table>
</div>




```python
X = dataset.iloc[:, 1:-1].values # parcour position and level 
y = dataset.iloc[:, -1].values # parcour salary 
from sklearn.preprocessing import PolynomialFeatures # sklearn pour l categorielles dataset 
from sklearn.linear_model import LinearRegression
poly_reg = PolynomialFeatures(degree = 4)
X_poly = poly_reg.fit_transform(X) # x de degree 4  = matrix 
lin_reg = LinearRegression()
lin_reg.fit(X_poly, y)# équipée des X_poly et y pour la construction du modèle.

# Étape 4 : nous allons prédire les valeurs Salary
y_pred = lin_reg.predict(X_poly)

# Étape 5 : Comparer les valeurs réelles avec les valeurs prédites
df = pd.DataFrame({'Real Values':y, 'Predicted Values':y_pred})
df
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>Real Values</th>
      <th>Predicted Values</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>45000</td>
      <td>53356.643357</td>
    </tr>
    <tr>
      <th>1</th>
      <td>50000</td>
      <td>31759.906760</td>
    </tr>
    <tr>
      <th>2</th>
      <td>60000</td>
      <td>58642.191142</td>
    </tr>
    <tr>
      <th>3</th>
      <td>80000</td>
      <td>94632.867133</td>
    </tr>
    <tr>
      <th>4</th>
      <td>110000</td>
      <td>121724.941725</td>
    </tr>
    <tr>
      <th>5</th>
      <td>150000</td>
      <td>143275.058275</td>
    </tr>
    <tr>
      <th>6</th>
      <td>200000</td>
      <td>184003.496503</td>
    </tr>
    <tr>
      <th>7</th>
      <td>300000</td>
      <td>289994.172494</td>
    </tr>
    <tr>
      <th>8</th>
      <td>500000</td>
      <td>528694.638695</td>
    </tr>
    <tr>
      <th>9</th>
      <td>1000000</td>
      <td>988916.083916</td>
    </tr>
  </tbody>
</table>
</div>



# Étape 6 :
Visualisation des résultats de la régression polynomiale


```python
X_grid = np.arange(min(X), max(X), 0.1)
#This line creates an array X_grid with values ranging from the 
# minimum value of X to the maximum value of X with a step size of 0.1. 
# This is used to get a smooth curve for the polynomial regression line.
X_grid = X_grid.reshape((len(X_grid), 1))
#Reshapes the X_grid array into a column vector.
# This is necessary because the poly_reg.fit_transform() method expects a 2D array as input.
plt.scatter(X, y, color = 'red')
plt.scatter (X, y_pred, color = 'green')
plt.plot(X_grid, lin_reg.predict(poly_reg.fit_transform(X_grid)), color = 'black')
plt.title('Régression polynomiale')
plt.xlabel('Position Level')
plt.ylabel('Salary')
plt.show()
```


    
![png](output_15_0.png)
    



```python

```
