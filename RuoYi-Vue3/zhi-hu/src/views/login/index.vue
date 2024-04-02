<template>
  <div class="login_container">
    <div class="main">
    <!-- container b-container is-txl -->
    <div class="container a-container" :class="{ 'is-txl': !isLogin }">
      <form class="form">
        <h2 class="form_title title">创建账号</h2>
        <input class="form__input" type="text" placeholder="Name" name="name">
        <input class="form__input" type="email" placeholder="Email" name="email">
        <input class="form__input" type="password" placeholder="Password" name="password">
        <button type="submit" class="form__button button submit">注册</button>
      </form>
    </div>
    <!-- container b-container is-txl is-z200 -->
    <div class="container b-container" :class="{ 'is-txl': !isLogin, 'is-z200': !isLogin }">
      <form class="form">
        <h2 class="form_title title">登录账号</h2>
        <input class="form__input" type="email" placeholder="Email" name="email">
        <input class="form__input" type="password" placeholder="Password" name="password">
        <button type="submit" class="form__button button submit">登录</button>
      </form>
    </div>
    <!-- switch is-txr -->
    <div class="switch" :class="{ 'is-txr': !isLogin }">
      <div class="switch__circle"></div>
      <div class="switch__circle switch__circle--t"></div>
      <div class="switch__container" :class="{ 'is-hidden': isLogin }">
        <h2 class="switch__title title">欢迎回来 !</h2>
        <p class="switch__description description">为了与我们保持联系，请使用您的个人信息登录</p>
        <button class="switch__button button switch-btn" @click="isLogin = true">去注册</button>
      </div>
      <div class="switch__container" :class="{ 'is-hidden': !isLogin }">
        <h2 class="switch__title title">Hello Friend !</h2>
        <p class="switch__description description">输入您的个人资料，与我们一起开始旅程</p>
        <button class="switch__button button switch-btn" @click="isLogin = false">去登录</button>
      </div>
    </div>
  </div>
  </div>
</template>

<script lang="ts" setup>
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';

const isLogin = ref(true);  // 登录还是注册
const route = useRouter();
onMounted(() => {
  // 判断路由参数 是登录还是 注册
  route.currentRoute.value.query.type === 'login' ? isLogin.value = false : isLogin.value = true;
})

</script>

<style lang="scss" scoped>
.login_container {
  background: url('../../assets/login_bg.png') no-repeat center center fixed;
  width: 100vw;
  height: 100vh;
}
/**/
.main {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 1000px;
  min-width: 1000px;
  min-height: 600px;
  height: 600px;
  padding: 25px;
  background-color: #ecf0f3;
  box-shadow:
    10px 10px 10px #d1d9e6,
    -10px -10px 10px #f9f9f9;
  border-radius: 12px;
  overflow: hidden;
  background-size: cover;

  @media(max-width: 1200px) {
    transform: scale(.7);
  }

  @media(max-width: 1000px) {
    transform: scale(.6);
  }

  @media(max-width: 800px) {
    transform: scale(.5);
  }

  @media(max-width: 600px) {
    transform: scale(.4);
  }
}

.container {
  display: flex;
  justify-content: center;
  align-items: center;
  position: absolute;

  top: 0;
  width: 600px;
  height: 100%;
  padding: 25px;

  background-color: #ecf0f3;
  transition: 1.25s;
}

.form {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  width: 100%;
  height: 100%;

  &__icon {
    object-fit: contain;
    width: 30px;
    margin: 0 5px;
    opacity: .5;
    transition: .15s;

    &:hover {
      opacity: 1;
      transition: .15s;
      cursor: pointer;

    }
  }

  &__input {
    width: 350px;
    height: 40px;
    margin: 4px 0;

    padding-left: 25px;
    font-size: 13px;
    letter-spacing: .15px;
    border: none;
    outline: none;

    font-family: 'Montserrat', sans-serif;
    background-color: #ecf0f3;
    transition: .25s ease;
    border-radius: 8px;

    box-shadow:
      inset 2px 2px 4px #d1d9e6,
      inset -2px -2px 4px #f9f9f9;

    &:focus {
      box-shadow:
        inset 4px 4px 4px #d1d9e6,
        inset -4px -4px 4px #f9f9f9;
    }
  }

  &__span {
    margin-top: 30px;
    margin-bottom: 12px;
  }

  &__link {
    color: #181818;
    font-size: 15px;
    margin-top: 25px;
    border-bottom: 1px solid #a0a5a8;
    line-height: 2;
  }
}

.title {
  font-size: 34px;
  font-weight: 700;
  line-height: 3;
  color: #181818;
}

.description {
  font-size: 14px;
  letter-spacing: .25px;
  text-align: center;
  line-height: 1.6;
}

.button {
  width: 180px;
  height: 50px;
  border-radius: 25px;
  margin-top: 50px;
  font-weight: 700;
  font-size: 14px;
  letter-spacing: 1.15px;

  background-color: #4B70E2;
  color: #f9f9f9;
  box-shadow:
    8px 8px 16px #d1d9e6,
    -8px -8px 16px #f9f9f9;

  border: none;
  outline: none;
}

/**/

.a-container {
  z-index: 100;
  left: calc(100% - 600px);
}

.b-container {
  left: calc(100% - 600px);
  z-index: 0;
}

.switch {
  display: flex;
  justify-content: center;
  align-items: center;
  position: absolute;
  top: 0;
  left: 0;
  height: 100%;
  width: 400px;

  padding: 50px;
  z-index: 200;
  transition: 1.25s;

  background-color: #ecf0f3;
  overflow: hidden;


  box-shadow:
    4px 4px 10px #d1d9e6,
    -4px -4px 10px #f9f9f9;

  &__circle {
    position: absolute;
    width: 500px;
    height: 500px;
    border-radius: 50%;
    background-color: #ecf0f3;
    box-shadow:
      inset 8px 8px 12px #d1d9e6,
      inset -8px -8px 12px #f9f9f9;

    bottom: -60%;
    left: -60%;
    transition: 1.25s;

    &--t {
      top: -30%;
      left: 60%;
      width: 300px;
      height: 300px;
    }
  }

  &__container {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    position: absolute;
    width: 400px;
    padding: 50px 55px;

    transition: 1.25s;

  }

  &__button {
    cursor: pointer;

    &:hover {
      box-shadow:
        6px 6px 10px #d1d9e6,
        -6px -6px 10px #f9f9f9;
      transform: scale(.985);
      transition: .25s;
    }

    &:active,
    &:focus {
      box-shadow:
        2px 2px 6px #d1d9e6,
        -2px -2px 6px #f9f9f9;
      transform: scale(.97);
      transition: .25s;
    }
  }
}

/**/
.is-txr {
  left: calc(100% - 400px);
  transition: 1.25s;
  transform-origin: left;
}

.is-txl {
  left: 0;
  transition: 1.25s;
  transform-origin: right;
}

.is-z200 {
  z-index: 200;
  transition: 1.25s;
}

.is-hidden {
  visibility: hidden;
  opacity: 0;
  position: absolute;
  transition: 1.25s;
}

.is-gx {
  animation: is-gx 1.25s;
}

@keyframes is-gx {

  0%,
  10%,
  100% {
    width: 400px;
  }

  30%,
  50% {
    width: 500px;
  }
}
</style>