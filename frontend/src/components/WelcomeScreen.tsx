import { useState, useEffect } from 'react';
import { InputForm } from './InputForm';
import { Button } from './ui/button';

interface WelcomeScreenProps {
  handleSubmit: (
    submittedInputValue: string,
    persona: string,
    model: string
  ) => void;
  onCancel: () => void;
  isLoading: boolean;
}

export const WelcomeScreen: React.FC<WelcomeScreenProps> = ({
  handleSubmit,
  onCancel,
  isLoading,
}) => {
  const [isDark, setIsDark] = useState(true);

  useEffect(() => {
    // Check if dark mode is already set
    const isDarkMode = document.documentElement.classList.contains('dark');
    setIsDark(isDarkMode);
  }, []);

  const toggleTheme = () => {
    const newTheme = !isDark;
    setIsDark(newTheme);
    
    if (newTheme) {
      document.documentElement.classList.add('dark');
      localStorage.setItem('theme', 'dark');
    } else {
      document.documentElement.classList.remove('dark');
      localStorage.setItem('theme', 'light');
    }
  };

  return (
    <div className="h-full flex flex-col items-center justify-center text-center px-6 flex-1 w-full max-w-4xl mx-auto">
      {/* Theme Toggle - Top Right */}
      <div className="absolute top-6 right-6 z-10">
        <Button
          variant="outline"
          size="icon"
          onClick={toggleTheme}
          className="h-10 w-10 rounded-full border-2 border-neutral-300 dark:border-neutral-600 bg-white/10 dark:bg-neutral-800/50 backdrop-blur-sm hover:bg-white/20 dark:hover:bg-neutral-700/50 transition-all duration-300"
        >
          {isDark ? (
            <svg className="h-5 w-5 text-yellow-400" fill="currentColor" viewBox="0 0 20 20">
              <path fillRule="evenodd" d="M10 2a1 1 0 011 1v1a1 1 0 11-2 0V3a1 1 0 011-1zm4 8a4 4 0 11-8 0 4 4 0 018 0zm-.464 4.95l.707.707a1 1 0 001.414-1.414l-.707-.707a1 1 0 00-1.414 1.414zm2.12-10.607a1 1 0 010 1.414l-.706.707a1 1 0 11-1.414-1.414l.707-.707a1 1 0 011.414 0zM17 11a1 1 0 100-2h-1a1 1 0 100 2h1zm-7 4a1 1 0 011 1v1a1 1 0 11-2 0v-1a1 1 0 011-1zM5.05 6.464A1 1 0 106.465 5.05l-.708-.707a1 1 0 00-1.414 1.414l.707.707zm1.414 8.486l-.707.707a1 1 0 01-1.414-1.414l.707-.707a1 1 0 011.414 1.414zM4 11a1 1 0 100-2H3a1 1 0 000 2h1z" clipRule="evenodd" />
            </svg>
          ) : (
            <svg className="h-5 w-5 text-slate-600" fill="currentColor" viewBox="0 0 20 20">
              <path d="M17.293 13.293A8 8 0 016.707 2.707a8.001 8.001 0 1010.586 10.586z" />
            </svg>
          )}
        </Button>
      </div>

      {/* Main Content */}
      <div className="flex flex-col items-center gap-8 animate-fadeInUp">
        {/* Welcome Text */}
        <div className="space-y-4">
          <img src="./ai-icon2.png" alt="RAG Analytics" className="w-24 h-24 mb-4 justify-center items-center mx-auto" />
          <h1 className="text-6xl md:text-5xl font-bold bg-gradient-to-r from-blue-400 via-purple-500 to-red-500 bg-clip-text text-transparent leading-tight">
            Welcome to RAG Analytics
          </h1>
          <p className="text-xl md:text-2xl text-neutral-600 dark:text-neutral-300 font-light max-w-2xl leading-relaxed">
            Enter your query and let's get started with intelligent analytics.
          </p>
        </div>

        {/* Input Form */}
        <div className="w-full max-w-2xl mt-8">
          <InputForm
            onSubmit={handleSubmit}
            isLoading={isLoading}
            onCancel={onCancel}
            hasHistory={false}
          />
        </div>

        {/* Theme Info */}
        <div className="mt-8 text-sm text-neutral-500 dark:text-neutral-400 space-y-1">
          <p>Current theme: <span className="font-medium">{isDark ? 'Dark' : 'Light'}</span></p>
          {/* <p className="text-xs">
            {isDark ? 'Dark theme colors: #1a1a1a (bg), #f5f5f5 (text)' : 'Light theme colors: #ffffff (bg), #1a1a1a (text)'}
          </p> */}
        </div>
      </div>
    </div>
  );
};
