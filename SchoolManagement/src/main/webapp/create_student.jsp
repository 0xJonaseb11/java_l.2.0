<!doctype html>

<html lang="en"> 

 <head> 

  <meta charset="UTF-8"> 

  <title>School management login</title> 

  <style>
  @import url('https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500;600;700&display=swap');
*
{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Quicksand', sans-serif;
}
body 
{
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background: #000;
}
section 
{
  position: absolute;
  width: 100vw;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 2px;
  flex-wrap: wrap;
  overflow: hidden;
}


section span 
{
  position: relative;
  display: block;
  width: calc(6.25vw - 2px);
  height: calc(6.25vw - 2px);
  background: #181818;
  z-index: 2;
  transition: 1.5s;
}
section span:hover 
{
  background: #0f0;
  transition: 0s;
}

section .container
{
  position: absolute;
  width: 500px;
  background: #222;  
  z-index: 1000;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 40px;
  border-radius: 4px;
  box-shadow: 0 15px 35px rgba(0,0,0,9);
}
section .container .content 
{
  position: relative;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  gap: 40px;
}
section .container .content h2 
{
  font-size: 2em;
  color: #0f0;
  text-transform: uppercase;
}
section .container .content .form 
{
  width: 100%;
  display: flex;
  flex-direction: column;
  gap: 25px;
}
section .container .content .form .inputBox
{
  position: relative;
  width: 100%;
}
section .container .content .form .inputBox input 
{
  position: relative;
  width: 100%;
  background: #333;
  border: none;
  outline: none;
  padding: 25px 10px 7.5px;
  border-radius: 4px;
  color: #fff;
  font-weight: 500;
  font-size: 1em;
}
select.inputBox 
{
  position: relative;
  width: 100%;
  background: #333;
  border: none;
  outline: none;
  padding: 25px 10px 7.5px;
  border-radius: 4px;
  color: #fff;
  font-weight: 500;
  font-size: 1em;
}
section .container .content .form .inputBox i 
{
  position: absolute;
  left: 0;
  padding: 15px 10px;
  font-style: normal;
  color: #aaa;
  transition: 0.5s;
  pointer-events: none;
}
.container .content .form .inputBox input:focus ~ i,
.container .content .form .inputBox input:valid ~ i
{
  transform: translateY(-7.5px);
  font-size: 0.8em;
  color: #fff;
}
.container .content .form .links 
{
  position: relative;
  width: 100%;
  display: flex;
  justify-content: space-between;
}
.container .content .form .links a 
{
  color: #fff;
  text-decoration: none;
}
.container .content .form .links a:nth-child(2)
{
  color: #0f0;
  font-weight: 600;
}
.container .content .form .inputBox input[type="submit"]
{
  padding: 10px;
  background: #0f0;
  color: #000;
  font-weight: 600;
  font-size: 1.35em;
  letter-spacing: 0.05em;
  cursor: pointer;
}
input[type="submit"]:active
{
  opacity: 0.6;
}
@media (max-width: 900px)
{
  section span 
  {
    width: calc(10vw - 2px);
    height: calc(10vw - 2px);
  }
}
@media (max-width: 600px)
{
  section span 
  {
    width: calc(20vw - 2px);
    height: calc(20vw - 2px);
  }
}
  </style>

 </head> 

 <body> <!-- partial:index.partial.html --> 

  <section> 

   <div class="container"> 

    <div class="content"> 

     <h2>Create student</h2> 

     <form class="form" action="Student" method="post"> 

      <div class="inputBox"> 

       <input type="text" name="name" required> <i>Full name</i> 

      </div> 
          <div class="inputBox"> 

       <input type="text" name="age" required> <i>Age</i> 

      </div> 
        <div class="inputBox"> 

       <input type="text" name="email" required> <i>Email</i> 

      </div> 

      <div class="inputBox"> 

       <input type="text" name="school" required> <i>School</i> 

      </div> 
        <div class="inputBox"> 

       <input type="text" name="mobile" required> <i>Phone number</i> 

      </div> 
    
          

      


     

      <div class="inputBox"> 

       <input type="submit" value="Create"> 

      </div> 

     </div> 

    </div> 

   </form> 

  </section> <!-- partial --> 

 </body>

</html>